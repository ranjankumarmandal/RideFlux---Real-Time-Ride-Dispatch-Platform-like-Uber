package com.ranjankumarmandal.rider_service.service;

import com.ranjankumarmandal.rider_service.dto.CreateRideRequest;
import com.ranjankumarmandal.rider_service.dto.RideResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RideService {

    Mono<RideResponse> createRide(CreateRideRequest request, UUID riderId);
}