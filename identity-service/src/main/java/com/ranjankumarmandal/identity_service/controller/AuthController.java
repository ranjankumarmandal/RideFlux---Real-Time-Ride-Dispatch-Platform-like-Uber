package com.ranjankumarmandal.identity_service.controller;

import com.ranjankumarmandal.identity_service.dto.LoginRequest;
import com.ranjankumarmandal.identity_service.dto.RegisterRequest;
import com.ranjankumarmandal.identity_service.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register/rider")
    public Mono<?> registerRider(
            @Valid @RequestBody RegisterRequest request
    ) {
        return authService.registerRider(request);
    }

    @PostMapping("/register/driver")
    public Mono<?> registerDriver(
            @Valid @RequestBody RegisterRequest request
    ) {
        return authService.registerDriver(request);
    }

    @PostMapping("/login")
    public Mono<?> login(
            @Valid @RequestBody LoginRequest request
    ) {
        return authService.login(request);
    }
}