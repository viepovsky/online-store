package com.viepovsky.open_feign_clients.exception_handling;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class WrongRequestException extends RuntimeException {

    private final HttpStatus status;

    private final String message;

    private final String id;

    private final String additionalMessage;

    public WrongRequestException(ErrorReason errorReason, String id, String additionalMessage) {
        super(errorReason.getMessage());
        this.status = errorReason.getStatus();
        this.message = errorReason.getMessage();
        this.id = id;
        this.additionalMessage = additionalMessage;
    }

    public WrongRequestException(ErrorReason errorReason, String id) {
        this(errorReason, id, null);
    }

    public WrongRequestException(ErrorReason errorReason) {
        this(errorReason, null, null);
    }

}
