package com.ranjankumarmandal.identity_service.repository;

import com.ranjankumarmandal.identity_service.entity.RefreshToken;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RefreshTokenRepository
        extends ReactiveCrudRepository<RefreshToken, UUID> {

    Mono<RefreshToken> findByToken(String token);

}