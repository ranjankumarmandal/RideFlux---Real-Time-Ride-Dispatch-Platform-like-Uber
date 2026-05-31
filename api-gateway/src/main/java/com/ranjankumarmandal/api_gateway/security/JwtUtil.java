package com.ranjankumarmandal.api_gateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final String SECRET =
            "rideflux-super-secret-key-for-jwt-token";

    public Claims extractClaims(String token) {

        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validate(String token) {

        try {
            extractClaims(token);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}