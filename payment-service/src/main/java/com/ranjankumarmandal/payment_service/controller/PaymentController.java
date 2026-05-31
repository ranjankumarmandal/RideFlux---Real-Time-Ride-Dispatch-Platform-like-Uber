package com.ranjankumarmandal.payment_service.controller;

import com.ranjankumarmandal.payment_service.dto.PaymentRequest;
import com.ranjankumarmandal.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Mono<Void> processPayment(@RequestBody PaymentRequest request) {
        return paymentService.processPayment(request);
    }
}