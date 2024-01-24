package com.viepovsky.open_feign_clients.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler {

    @ExceptionHandler(WrongRequestException.class)
    public ResponseEntity<Object> handleWrongRequestException(WrongRequestException exception) {
        String message = getExceptionMessage(exception);
        HttpStatus status = exception.getStatus();
        return ResponseEntity.status(status)
                             .body(message);
    }

    private String getExceptionMessage(WrongRequestException exception) {
        String message = exception.getMessage();
        message += addIdCausingProblemsIfSet(exception);
        message += addAdditionalMessageIfSet(exception);
        return message;
    }

    private String addIdCausingProblemsIfSet(WrongRequestException exception) {
        return exception.getId() != null ? "\nId causing error:" + exception.getId() : "";
    }

    private String addAdditionalMessageIfSet(WrongRequestException exception) {
        return exception.getAdditionalMessage() != null ? "\n" + exception.getAdditionalMessage() : "";
    }
}
