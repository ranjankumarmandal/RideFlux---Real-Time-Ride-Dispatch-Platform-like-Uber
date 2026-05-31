package com.ranjankumarmandal.dispatch_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("dispatch_requests")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DispatchRequest {

    @Id
    private UUID id;

    private UUID rideId;

    private UUID riderId;

    private String status; // SEARCHING, ASSIGNED, FAILED

    private UUID assignedDriverId;

    private LocalDateTime createdAt;
}