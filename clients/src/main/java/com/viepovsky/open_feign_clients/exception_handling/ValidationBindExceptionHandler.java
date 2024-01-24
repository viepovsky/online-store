package com.viepovsky.open_feign_clients.exception_handling;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationBindExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> handleValidationException(BindException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest()
                .body(errors);
    }

}
