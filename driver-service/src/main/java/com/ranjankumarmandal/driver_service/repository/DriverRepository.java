package com.ranjankumarmandal.driver_service.repository;

import com.ranjankumarmandal.driver_service.entity.Driver;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface DriverRepository extends ReactiveCrudRepository<Driver, UUID> {
}