package com.ranjankumarmandal.driver_service.dto;

import lombok.Data;

@Data
public class DriverLocationUpdateRequest {

    private double latitude;
    private double longitude;
}