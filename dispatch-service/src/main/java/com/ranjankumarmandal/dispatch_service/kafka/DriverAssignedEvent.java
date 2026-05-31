package com.ranjankumarmandal.dispatch_service.kafka;

import lombok.Builder;

import java.util.UUID;

@Builder
public record DriverAssignedEvent(
        UUID rideId,
        UUID driverId,
        UUID riderId
) {}