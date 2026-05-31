package com.ranjankumarmandal.rider_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("rides")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ride {

    @Id
    private UUID id;

    private UUID riderId;

    private double pickupLatitude;
    private double pickupLongitude;

    private double dropLatitude;
    private double dropLongitude;

    private String vehicleType;

    private String status;

    private LocalDateTime createdAt;
}