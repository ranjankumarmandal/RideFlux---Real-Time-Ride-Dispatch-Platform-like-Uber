package com.ranjankumarmandal.trip_service.service.impl;

import com.ranjankumarmandal.trip_service.dto.TripStartRequest;
import com.ranjankumarmandal.trip_service.entity.Trip;
import com.ranjankumarmandal.trip_service.entity.TripStatus;
import com.ranjankumarmandal.trip_service.kafka.TripCompletedEvent;
import com.ranjankumarmandal.trip_service.kafka.TripStartedEvent;
import com.ranjankumarmandal.trip_service.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public Mono<Void> startTrip(TripStartRequest request) {

        Trip trip = Trip.builder()
                .id(UUID.randomUUID())
                .rideId(request.getRideId())
                .riderId(request.getRiderId())
                .driverId(request.getDriverId())
                .status(TripStatus.STARTED)
                .startTime(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();

        return tripRepository.save(trip)
                .doOnSuccess(saved ->
                        kafkaTemplate.send("trip-started",
                                TripStartedEvent.builder()
                                        .tripId(saved.getId())
                                        .rideId(saved.getRideId())
                                        .driverId(saved.getDriverId())
                                        .riderId(saved.getRiderId())
                                        .build()
                        )
                )
                .then();
    }

    @Override
    public Mono<Void> endTrip(String tripId) {

        return tripRepository.findById(UUID.fromString(tripId))
                .flatMap(trip -> {
                    trip.setStatus(TripStatus.COMPLETED);
                    trip.setEndTime(LocalDateTime.now());

                    return tripRepository.save(trip)
                            .doOnSuccess(saved ->
                                    kafkaTemplate.send("trip-completed",
                                            TripCompletedEvent.builder()
                                                    .tripId(saved.getId())
                                                    .rideId(saved.getRideId())
                                                    .driverId(saved.getDriverId())
                                                    .riderId(saved.getRiderId())
                                                    .build()
                                    )
                            );
                })
                .then();
    }
}