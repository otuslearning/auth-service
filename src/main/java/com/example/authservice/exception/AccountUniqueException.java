package com.example.authservice.exception;

public class AccountUniqueException extends RuntimeException {
    public static final String USERNAME_NOT_UNIQUE = "Username not unique";

    public AccountUniqueException() {
        super(USERNAME_NOT_UNIQUE);
    }
}
