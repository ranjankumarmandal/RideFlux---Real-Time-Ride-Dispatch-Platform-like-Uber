package com.ranjankumarmandal.driver_service.service;

import com.ranjankumarmandal.driver_service.dto.DriverLocationUpdateRequest;
import com.ranjankumarmandal.driver_service.kafka.DriverLocationUpdatedEvent;
import com.ranjankumarmandal.driver_service.redis.DriverLocationService;
import com.ranjankumarmandal.driver_service.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverLocationService redisService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public Mono<Void> updateLocation(UUID driverId, DriverLocationUpdateRequest request) {

        return redisService.updateLocation(
                        driverId.toString(),
                        request.getLatitude(),
                        request.getLongitude()
                )
                .doOnSuccess(r ->
                        kafkaTemplate.send("driver-location-updated",
                                DriverLocationUpdatedEvent.builder()
                                        .driverId(driverId)
                                        .latitude(request.getLatitude())
                                        .longitude(request.getLongitude())
                                        .build()
                        )
                )
                .then();
    }
}