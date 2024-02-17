package com.example.authservice.service;

import com.example.authservice.api.AccountService;
import com.example.authservice.api.LoginResponseDto;
import com.example.authservice.api.RegistrationRequestDto;
import com.example.authservice.api.TokenService;
import com.example.authservice.converter.AccountConvertor;
import com.example.authservice.domain.Account;
import com.example.authservice.exception.AccountUnauthorizedException;
import com.example.authservice.exception.AccountUniqueException;
import com.example.authservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountConvertor accountConvertor;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    @Override
    public void register(RegistrationRequestDto request) {
        accountRepository.findAccountByUsername(request.getUsername())
                .ifPresent(a -> {throw new AccountUniqueException();});
        Account account = accountConvertor.convert(request);
        account.setPasswordHash(encodePassword(request.getPassword()));
        accountRepository.save(account);
    }

    @Override
    public LoginResponseDto login(String username, String password) {
        Optional<Account> account = accountRepository.findAccountByUsername(username);
        if (account.isEmpty()) {
            throw new AccountUnauthorizedException();
        }
        checkPassword(password, account.get().getPasswordHash());
        return LoginResponseDto.builder()
                .token(tokenService.generateToken(String.valueOf(account.get().getId())))
                .build();
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
    private void checkPassword(String password, String passwordHash) {
        if (!passwordEncoder.matches(password, passwordHash)) {
            throw new AccountUnauthorizedException();
        }
    }
}
