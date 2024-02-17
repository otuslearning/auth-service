package com.example.authservice.converter;

import com.example.authservice.api.RegistrationRequestDto;
import com.example.authservice.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountConvertor {
    public Account convert(RegistrationRequestDto dto) {
        Account account = new Account();
        account.setUsername(dto.getUsername());
        return account;
    }

}
