package org.proxidev.productservice.handleException;


import jakarta.servlet.http.HttpServletRequest;
import org.proxidev.productservice.payload.ErrorResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ErrorResponseApi> handleException(ResourceNotFoundException e, WebRequest request) {
        ErrorResponseApi dto = ErrorResponseApi.builder()
                .message(e.getMessage())
                .errorCode(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .error(request.getDescription(false))
                .build();
       return  new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
