package com.ranjankumarmandal.rider_service.dto;

import lombok.Data;

@Data
public class CreateRideRequest {

    private double pickupLatitude;
    private double pickupLongitude;
    private double dropLatitude;
    private double dropLongitude;
    private String vehicleType;
}