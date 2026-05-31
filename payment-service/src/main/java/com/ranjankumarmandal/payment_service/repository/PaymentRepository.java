package com.ranjankumarmandal.payment_service.repository;

import com.ranjankumarmandal.payment_service.entity.Payment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface PaymentRepository extends ReactiveCrudRepository<Payment, UUID> {
}