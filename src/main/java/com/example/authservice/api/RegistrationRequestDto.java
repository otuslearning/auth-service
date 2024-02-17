package com.example.authservice.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequestDto {
    String username;
    String password;
}
