package com.example.authservice.web;

import com.example.authservice.api.AccountService;
import com.example.authservice.api.LoginRequestDto;
import com.example.authservice.api.LoginResponseDto;
import com.example.authservice.api.RegistrationRequestDto;
import com.example.authservice.api.TokenService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.authservice.util.JwtUtils.HEADER_ACCOUNT_ID;
import static com.example.authservice.util.JwtUtils.HEADER_TOKEN;

@RestController
@RequiredArgsConstructor
@RequestMapping("${application.web.prefix.public}")
public class AccountController {
    private final AccountService accountService;
    private final TokenService tokenService;

    @PostMapping("/register")
    public void register(@RequestBody RegistrationRequestDto requestDto) {
        accountService.register(requestDto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto) {
        return accountService.login(requestDto.getUsername(), requestDto.getPassword());
    }

    @PostMapping("/logout")
    public void logout() {
        // TODO
    }

    @PostMapping
    public void auth(@RequestHeader(value = HEADER_TOKEN, defaultValue = "") String token, HttpServletResponse response) {
        response.addHeader(HEADER_ACCOUNT_ID, tokenService.getAccountIdFromToken(token));
    }
}
