package com.ranjankumarmandal.payment_service.service;

import com.ranjankumarmandal.payment_service.dto.PaymentRequest;
import com.ranjankumarmandal.payment_service.entity.Payment;
import com.ranjankumarmandal.payment_service.kafka.PaymentCompletedEvent;
import com.ranjankumarmandal.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public Mono<Void> processPayment(PaymentRequest request) {

        Payment payment = Payment.builder()
                .id(UUID.randomUUID())
                .tripId(request.getTripId())
                .riderId(request.getRiderId())
                .driverId(request.getDriverId())
                .amount(request.getAmount())
                .status("SUCCESS")
                .createdAt(LocalDateTime.now())
                .build();

        return paymentRepository.save(payment)
                .doOnSuccess(saved ->
                        kafkaTemplate.send("payment-completed",
                                PaymentCompletedEvent.builder()
                                        .paymentId(saved.getId())
                                        .tripId(saved.getTripId())
                                        .riderId(saved.getRiderId())
                                        .driverId(saved.getDriverId())
                                        .status(saved.getStatus())
                                        .build()
                        )
                )
                .then();
    }
}