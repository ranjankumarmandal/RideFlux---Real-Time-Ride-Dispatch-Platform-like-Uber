package com.ranjankumarmandal.payment_service.kafka;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PaymentCompletedEvent(
        UUID paymentId,
        UUID tripId,
        UUID riderId,
        UUID driverId,
        String status
) {}