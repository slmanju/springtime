package com.slmanju.security.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds error information.
 *
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

  private int errorCode;
  private String errorMessage;
  private List<String> errors;

  public ErrorResponse(int errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.errors = new ArrayList<>();
  }

  public ErrorResponse withErrors(final List<String> errors) {
    this.errors = errors;
    return this;
  }

  public static ErrorResponse of(int errorCode, String errorMessage) {
    return new ErrorResponse(errorCode, errorMessage);
  }

  public static ErrorResponse badRequest(String errorMessage) {
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);
  }

  public static ErrorResponse notFound(String errorMessage) {
    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), errorMessage);
  }

  public static ErrorResponse notAllowed(String errorMessage) {
    return new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), errorMessage);
  }

  public static ErrorResponse internalServerError(String errorMessage) {
    return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage);
  }

}
