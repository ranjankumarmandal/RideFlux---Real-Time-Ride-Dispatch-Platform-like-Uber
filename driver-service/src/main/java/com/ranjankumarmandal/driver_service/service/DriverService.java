package com.ranjankumarmandal.driver_service.service;

import com.ranjankumarmandal.driver_service.dto.DriverLocationUpdateRequest;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface DriverService {

    Mono<Void> updateLocation(UUID driverId, DriverLocationUpdateRequest request);
}