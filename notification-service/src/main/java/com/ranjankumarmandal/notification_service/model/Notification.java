package com.ranjankumarmandal.notification_service.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private UUID id;

    private UUID userId;

    private String message;

    private NotificationType type;

    private LocalDateTime createdAt;
}