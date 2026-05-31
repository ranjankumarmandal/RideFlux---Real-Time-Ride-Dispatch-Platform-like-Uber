package com.ranjankumarmandal.identity_service.repository;

import com.ranjankumarmandal.identity_service.entity.Role;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface RoleRepository
        extends ReactiveCrudRepository<Role, Long> {

    Mono<Role> findByName(String name);

}