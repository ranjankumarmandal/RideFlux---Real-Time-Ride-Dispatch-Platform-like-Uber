package com.ranjankumarmandal.driver_service.kafka;

import lombok.Builder;

import java.util.UUID;

@Builder
public record DriverLocationUpdatedEvent(
        UUID driverId,
        double latitude,
        double longitude
) {}