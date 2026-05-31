package com.ranjankumarmandal.dispatch_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RideRequestedEvent {

    private UUID rideId;
    private UUID riderId;

    private double pickupLatitude;
    private double pickupLongitude;

    private String vehicleType;
}