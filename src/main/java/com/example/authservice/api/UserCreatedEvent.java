package com.example.authservice.api;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreatedEvent {
    private String accountGuid;
}
