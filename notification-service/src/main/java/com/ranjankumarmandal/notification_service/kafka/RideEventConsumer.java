package com.ranjankumarmandal.notification_service.kafka;

import com.ranjankumarmandal.notification_service.dto.NotificationEvent;
import com.ranjankumarmandal.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RideEventConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "ride-requested")
    public void rideRequested(String event) {

        NotificationEvent notification = new NotificationEvent();
        notification.setMessage("Your ride has been requested");
        notification.setType("RIDE_REQUESTED");

        notificationService.sendNotification(notification).subscribe();
    }
}