package com.slmanju.springsecurity.restsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> noHandlerFoundException(NoHandlerFoundException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(HttpStatus.NOT_FOUND.value());
        response.setErrorMessage("Invalid URL [" + request.getRequestURL() + "]");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { AuthenticationException.class })
    public ResponseEntity<Object> handleAuthenticationException(Exception ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(HttpStatus.BAD_REQUEST.value());
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnyException(Exception ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode( HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
