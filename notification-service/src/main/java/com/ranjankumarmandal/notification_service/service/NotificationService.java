package com.ranjankumarmandal.notification_service.service;

import com.ranjankumarmandal.notification_service.dto.NotificationEvent;
import reactor.core.publisher.Mono;

public interface NotificationService {

    Mono<Void> sendNotification(NotificationEvent event);
}