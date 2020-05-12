package com.slmanju.springbootbasic.core;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Globally catch exception and converts into meaningful status and objects.
 *
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@RestControllerAdvice
public final class GlobalExceptionAdvicer
{

  @ExceptionHandler(value = { MethodArgumentTypeMismatchException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleTypeMismatch(MethodArgumentTypeMismatchException exception) {
    return ErrorResponse.badRequest(exception.getMessage());
  }

  @ExceptionHandler(value = { MethodArgumentNotValidException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleBadRequest(MethodArgumentNotValidException exception) {
    BindingResult bindingResult = exception.getBindingResult();
    List<String> errors = bindingResult.getAllErrors()
      .stream()
      .map(DefaultMessageSourceResolvable::getDefaultMessage)
      .collect(Collectors.toList());

    return ErrorResponse.badRequest(exception.getMessage()).withErrors(errors);
  }

  @ExceptionHandler(value = { HttpMessageNotReadableException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleMessageNotReadable(HttpMessageNotReadableException exception) {
    return ErrorResponse.badRequest("Required request body is missing");
  }

  @ExceptionHandler(value = { NoHandlerFoundException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleNoHandler(NoHandlerFoundException exception) {
    return ErrorResponse.badRequest(exception.getMessage());
  }

//  @ExceptionHandler(value = { ResourceNotFoundException.class })
//  @ResponseStatus(HttpStatus.NOT_FOUND)
//  public ErrorResponse handleResourceNotFound(ResourceNotFoundException exception) {
//    return ErrorResponse.notFound(exception.getMessage());
//  }

  @ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  public ErrorResponse handleMethodNotSupported(Exception exception) {
    return ErrorResponse.notAllowed(exception.getMessage());
  }

//  @ExceptionHandler(value = { BadCredentialsException.class, AuthenticationException.class})
//  public ErrorResponse handleUnauthorized(BadCredentialsException exception) {
//    return ErrorResponse.of(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
//  }

  @ExceptionHandler(value = { Exception.class })
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse handleInternalError(Exception exception) {
    return ErrorResponse.internalServerError(exception.getMessage());
  }

}
