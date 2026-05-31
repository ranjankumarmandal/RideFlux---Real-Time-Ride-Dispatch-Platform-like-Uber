package com.ranjankumarmandal.dispatch_service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DriverMatchResponse {

    private UUID driverId;
    private double distance;
}