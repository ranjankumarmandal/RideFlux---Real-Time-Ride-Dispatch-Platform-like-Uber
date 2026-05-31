package com.ranjankumarmandal.rider_service.controller;

import com.ranjankumarmandal.rider_service.dto.*;
import com.ranjankumarmandal.rider_service.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rides")
@RequiredArgsConstructor
public class RideController {

    private final RideService rideService;

    @PostMapping
    public Mono<RideResponse> createRide(
            @RequestBody CreateRideRequest request,
            @RequestHeader("X-USER-ID") UUID riderId
    ) {
        return rideService.createRide(request, riderId);
    }
}