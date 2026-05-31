package com.ranjankumarmandal.rider_service.repository;

import com.ranjankumarmandal.rider_service.entity.Ride;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface RideRepository extends ReactiveCrudRepository<Ride, UUID> {
}