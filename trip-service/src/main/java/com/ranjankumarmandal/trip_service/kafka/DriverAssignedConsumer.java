package com.ranjankumarmandal.trip_service.kafka;

import com.ranjankumarmandal.trip_service.dto.TripStartRequest;
import com.ranjankumarmandal.trip_service.service.TripService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DriverAssignedConsumer {

    private final TripService tripService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "driver-assigned")
    public void consume(String event) throws Exception {

        DriverAssignedEvent data =
                objectMapper.readValue(event, DriverAssignedEvent.class);

        TripStartRequest request = new TripStartRequest();
        request.setRideId(data.getRideId());
        request.setDriverId(data.getDriverId());
        request.setRiderId(data.getRiderId());

        tripService.startTrip(request).subscribe();
    }
}