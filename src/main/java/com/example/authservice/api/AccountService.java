package com.example.authservice.api;

public interface AccountService {
    void register(RegistrationRequestDto request);
    LoginResponseDto login (String username, String password);
}
