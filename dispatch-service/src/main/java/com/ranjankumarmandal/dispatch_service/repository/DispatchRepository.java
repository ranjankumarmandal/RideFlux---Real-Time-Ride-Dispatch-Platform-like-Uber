package com.ranjankumarmandal.dispatch_service.repository;

import com.ranjankumarmandal.dispatch_service.entity.DispatchRequest;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface DispatchRepository extends ReactiveCrudRepository<DispatchRequest, UUID> {
}