package com.ranjankumarmandal.trip_service.repository;

import com.ranjankumarmandal.trip_service.entity.Trip;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface TripRepository extends ReactiveCrudRepository<Trip, UUID> {
}