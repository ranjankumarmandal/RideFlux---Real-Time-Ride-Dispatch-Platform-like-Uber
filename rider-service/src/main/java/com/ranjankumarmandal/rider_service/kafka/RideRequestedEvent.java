package com.ranjankumarmandal.rider_service.kafka;

import lombok.Builder;

import java.util.UUID;

@Builder
public record RideRequestedEvent(
        UUID rideId,
        UUID riderId,
        String vehicleType
) {}