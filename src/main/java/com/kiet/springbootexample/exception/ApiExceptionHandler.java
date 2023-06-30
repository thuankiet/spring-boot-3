package com.kiet.springbootexample.exception;

import com.kiet.springbootexample.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {
    String message = ex.getMessage();
    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND.getReasonPhrase(), message);
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }
}
