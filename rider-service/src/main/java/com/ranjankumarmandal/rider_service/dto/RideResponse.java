package com.ranjankumarmandal.rider_service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RideResponse {

    private UUID rideId;
    private String status;
}