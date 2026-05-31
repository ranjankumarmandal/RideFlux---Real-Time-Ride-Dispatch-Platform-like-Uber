package com.ranjankumarmandal.dispatch_service.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class DriverSearchService {

    private final ReactiveRedisTemplate<String, String> redisTemplate;

    public Flux<String> findNearbyDrivers(double lat, double lon) {

        Circle circle = new Circle(
                new Point(lon, lat),
                new Distance(5, Metrics.KILOMETERS)
        );

        return redisTemplate.opsForGeo()
                .radius("driver:location", circle)
                .map(result -> result.getContent().getName());
    }
}