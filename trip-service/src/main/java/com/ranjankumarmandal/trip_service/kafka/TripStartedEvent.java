package com.ranjankumarmandal.trip_service.kafka;

import lombok.Builder;

import java.util.UUID;

@Builder
public record TripStartedEvent(
        UUID tripId,
        UUID rideId,
        UUID driverId,
        UUID riderId
) {}