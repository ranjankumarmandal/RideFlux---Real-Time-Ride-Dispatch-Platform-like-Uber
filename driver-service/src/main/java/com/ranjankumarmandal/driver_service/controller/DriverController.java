package com.ranjankumarmandal.driver_service.controller;

import com.ranjankumarmandal.driver_service.dto.DriverLocationUpdateRequest;
import com.ranjankumarmandal.driver_service.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PutMapping("/{driverId}/location")
    public Mono<Void> updateLocation(
            @PathVariable UUID driverId,
            @RequestBody DriverLocationUpdateRequest request
    ) {
        return driverService.updateLocation(driverId, request);
    }
}