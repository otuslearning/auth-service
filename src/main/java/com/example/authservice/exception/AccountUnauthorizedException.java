package com.example.authservice.exception;

public class AccountUnauthorizedException extends RuntimeException {
    public static final String USERNAME_OR_PASSWORD_NOT_VALID = "Username or password not valid";
    public static final String USER_NOT_AUTHORIZED = "User not authorized.";

    public AccountUnauthorizedException() {
        super(USERNAME_OR_PASSWORD_NOT_VALID);
    }

    public AccountUnauthorizedException(String message) {
        super(message);
    }
}
