package com.ranjankumarmandal.driver_service.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DriverLocationService {

    private final ReactiveRedisTemplate<String, String> redisTemplate;

    public Mono<Long> updateLocation(String driverId, double lat, double lng) {

        return redisTemplate.opsForGeo()
                .add("driver:location", new org.springframework.data.geo.Point(lng, lat), driverId);
    }
}