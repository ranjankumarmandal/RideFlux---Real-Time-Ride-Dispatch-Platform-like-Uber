package com.ranjankumarmandal.notification_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class NotificationEvent {

    private UUID userId;

    private String message;

    private String type;
}