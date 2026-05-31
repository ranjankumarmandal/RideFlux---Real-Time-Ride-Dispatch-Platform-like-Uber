package com.ranjankumarmandal.payment_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("payments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    private UUID id;

    private UUID tripId;

    private UUID riderId;

    private UUID driverId;

    private Double amount;

    private String status; // INITIATED, SUCCESS, FAILED

    private LocalDateTime createdAt;
}