package com.ranjankumarmandal.identity_service.service;

import com.ranjankumarmandal.identity_service.dto.AuthResponse;
import com.ranjankumarmandal.identity_service.dto.LoginRequest;
import com.ranjankumarmandal.identity_service.dto.RegisterRequest;
import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<AuthResponse> registerRider(RegisterRequest request);

    Mono<AuthResponse> registerDriver(RegisterRequest request);

    Mono<AuthResponse> login(LoginRequest request);

}