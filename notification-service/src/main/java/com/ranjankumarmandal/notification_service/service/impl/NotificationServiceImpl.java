package com.ranjankumarmandal.notification_service.service.impl;

import com.ranjankumarmandal.notification_service.dto.NotificationEvent;
import com.ranjankumarmandal.notification_service.model.Notification;
import com.ranjankumarmandal.notification_service.model.NotificationType;
import com.ranjankumarmandal.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    @Override
    public Mono<Void> sendNotification(NotificationEvent event) {

        Notification notification = Notification.builder()
                .id(UUID.randomUUID())
                .userId(event.getUserId())
                .message(event.getMessage())
                .type(NotificationType.valueOf(event.getType()))
                .createdAt(LocalDateTime.now())
                .build();

        // Simulate push/email/SMS integration
        System.out.println("📩 Notification Sent: " + notification);

        return Mono.empty();
    }
}