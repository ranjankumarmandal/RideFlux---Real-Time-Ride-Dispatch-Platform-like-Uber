package com.ranjankumarmandal.dispatch_service.service;

import com.ranjankumarmandal.dispatch_service.dto.RideRequestedEvent;
import com.ranjankumarmandal.dispatch_service.entity.DispatchRequest;
import com.ranjankumarmandal.dispatch_service.kafka.DriverAssignedEvent;
import com.ranjankumarmandal.dispatch_service.redis.DriverSearchService;
import com.ranjankumarmandal.dispatch_service.repository.DispatchRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DispatchService {

    private final DriverSearchService driverSearchService;
    private final DispatchRepository dispatchRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<Void> processRideRequest(String eventJson) {

        RideRequestedEvent event = objectMapper.readValue(
                eventJson,
                RideRequestedEvent.class
        );

        return driverSearchService.findNearbyDrivers(
                        event.getPickupLatitude(),
                        event.getPickupLongitude()
                )
                .next()
                .flatMap(driverId -> {

                    DispatchRequest request = DispatchRequest.builder()
                            .id(UUID.randomUUID())
                            .rideId(event.getRideId())
                            .riderId(event.getRiderId())
                            .assignedDriverId(UUID.fromString(driverId))
                            .status("ASSIGNED")
                            .createdAt(LocalDateTime.now())
                            .build();

                    return dispatchRepository.save(request)
                            .doOnSuccess(saved -> {

                                kafkaTemplate.send(
                                        "driver-assigned",
                                        DriverAssignedEvent.builder()
                                                .rideId(event.getRideId())
                                                .driverId(saved.getAssignedDriverId())
                                                .riderId(event.getRiderId())
                                                .build()
                                );
                            })
                            .then();
                });
    }
}