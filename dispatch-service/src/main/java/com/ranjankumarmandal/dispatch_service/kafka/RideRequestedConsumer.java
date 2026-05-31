package com.ranjankumarmandal.dispatch_service.kafka;

import com.ranjankumarmandal.dispatch_service.service.DispatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RideRequestedConsumer {

    private final DispatchService dispatchService;

    @KafkaListener(topics = "ride-requested")
    public void consume(String event) {
        dispatchService.processRideRequest(event).subscribe();
    }
}