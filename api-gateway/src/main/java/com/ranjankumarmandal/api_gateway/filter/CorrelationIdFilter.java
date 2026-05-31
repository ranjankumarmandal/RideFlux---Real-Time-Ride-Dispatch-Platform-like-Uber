package com.ranjankumarmandal.api_gateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class CorrelationIdFilter
        implements GlobalFilter {

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        String correlationId =
                UUID.randomUUID().toString();

        exchange.getRequest()
                .mutate()
                .header(
                        "X-Correlation-Id",
                        correlationId
                )
                .build();

        return chain.filter(exchange);
    }
}