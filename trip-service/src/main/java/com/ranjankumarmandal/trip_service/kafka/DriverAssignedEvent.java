package com.ranjankumarmandal.trip_service.kafka;

import lombok.Data;

import java.util.UUID;

@Data
public class DriverAssignedEvent {

    private UUID rideId;
    private UUID riderId;
    private UUID driverId;
}