package com.example.authservice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.authservice.api.TokenService;
import com.example.authservice.exception.AccountUnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.example.authservice.exception.AccountUnauthorizedException.USER_NOT_AUTHORIZED;

@Service
public class TokenServiceImpl implements TokenService {

    private static final String ACCOUNT_ID = "account-id";

    @Value("${application.jwt.secret}")
    private String jwtSecret;
    @Override
    public String generateToken(String accountId) {
        return JWT.create()
                .withClaim(ACCOUNT_ID, accountId)
                .sign(getAlgorithm());
    }

    @Override
    public String getAccountIdFromToken(String token) {
        try {
            return JWT.require(getAlgorithm())
                    .build()
                    .verify(token)
                    .getClaim(ACCOUNT_ID)
                    .asString();
        } catch (JWTVerificationException e) {
            throw new AccountUnauthorizedException(USER_NOT_AUTHORIZED);
        }
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(jwtSecret);
    }
}
