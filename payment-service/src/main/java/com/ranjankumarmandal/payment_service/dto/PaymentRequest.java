package com.ranjankumarmandal.payment_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PaymentRequest {

    private UUID tripId;
    private UUID riderId;
    private UUID driverId;
    private Double amount;
}