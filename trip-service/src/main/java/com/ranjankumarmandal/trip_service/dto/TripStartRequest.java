package com.ranjankumarmandal.trip_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TripStartRequest {

    private UUID rideId;
    private UUID riderId;
    private UUID driverId;
}