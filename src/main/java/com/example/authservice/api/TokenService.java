package com.example.authservice.api;

public interface TokenService {
    String generateToken(String accountId);
    String getAccountIdFromToken(String token);
}
