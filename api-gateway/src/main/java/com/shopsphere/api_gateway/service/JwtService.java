package com.shopsphere.api_gateway.service;

import io.jsonwebtoken.Claims;

public interface JwtService {

    String extractUsername(String token);

    Claims extractAllClaims(String token);

    boolean isTokenValid(String token);

    String extractUserId(String token);

    String extractRole(String token);
}