package com.ranjankumarmandal.trip_service.kafka;

import lombok.Builder;

import java.util.UUID;

@Builder
public record TripCompletedEvent(
        UUID tripId,
        UUID rideId,
        UUID driverId,
        UUID riderId
) {}