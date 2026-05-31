package com.ranjankumarmandal.rider_service.service;

import com.ranjankumarmandal.rider_service.dto.*;
import com.ranjankumarmandal.rider_service.entity.Ride;
import com.ranjankumarmandal.rider_service.kafka.RideRequestedEvent;
import com.ranjankumarmandal.rider_service.repository.RideRepository;
import com.ranjankumarmandal.rider_service.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public Mono<RideResponse> createRide(CreateRideRequest request, UUID riderId) {

        Ride ride = Ride.builder()
                .id(UUID.randomUUID())
                .riderId(riderId)
                .pickupLatitude(request.getPickupLatitude())
                .pickupLongitude(request.getPickupLongitude())
                .dropLatitude(request.getDropLatitude())
                .dropLongitude(request.getDropLongitude())
                .vehicleType(request.getVehicleType())
                .status("REQUESTED")
                .createdAt(LocalDateTime.now())
                .build();

        return rideRepository.save(ride)
                .doOnSuccess(saved ->
                        kafkaTemplate.send("ride-requested",
                                RideRequestedEvent.builder()
                                        .rideId(saved.getId())
                                        .riderId(saved.getRiderId())
                                        .vehicleType(saved.getVehicleType())
                                        .build())
                )
                .map(saved -> RideResponse.builder()
                        .rideId(saved.getId())
                        .status(saved.getStatus())
                        .build());
    }
}