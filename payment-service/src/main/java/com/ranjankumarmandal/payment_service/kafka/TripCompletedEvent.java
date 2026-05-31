package com.ranjankumarmandal.payment_service.kafka;

import lombok.Data;

import java.util.UUID;

@Data
public class TripCompletedEvent {

    private UUID tripId;
    private UUID riderId;
    private UUID driverId;
}