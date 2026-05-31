package com.ranjankumarmandal.driver_service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DriverResponse {

    private UUID driverId;
    private String status;
}