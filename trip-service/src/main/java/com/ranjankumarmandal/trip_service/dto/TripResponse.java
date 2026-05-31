package com.ranjankumarmandal.trip_service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TripResponse {

    private UUID tripId;
    private String status;
}