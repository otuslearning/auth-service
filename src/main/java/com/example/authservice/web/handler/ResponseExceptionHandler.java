package com.example.authservice.web.handler;

import com.example.authservice.api.ErrorDto;
import com.example.authservice.exception.AccountUnauthorizedException;
import com.example.authservice.exception.AccountUniqueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AccountUniqueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleNorFoundException(AccountUniqueException exception) {
        return ErrorDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(AccountUnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDto handleNorFoundException(AccountUnauthorizedException exception) {
        return ErrorDto.builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .message(exception.getMessage())
                .build();
    }
}
