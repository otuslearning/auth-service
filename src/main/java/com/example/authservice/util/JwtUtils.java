package com.example.authservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {
    public static final String HEADER_TOKEN = "X-Auth-Token";
    public static final String HEADER_ACCOUNT_GUID = "X-Account-Guid";
}
