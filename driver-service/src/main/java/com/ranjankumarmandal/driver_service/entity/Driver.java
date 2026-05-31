package com.ranjankumarmandal.driver_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("drivers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    private UUID id;

    private String name;

    private String phone;

    private String vehicleNumber;

    private String vehicleType;

    private String status; // ONLINE / OFFLINE / BUSY

    private LocalDateTime createdAt;
}