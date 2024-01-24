package com.viepovsky.open_feign_clients.exception_handling;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorReason {
    BASKET_NOT_FOUND(HttpStatus.NOT_FOUND, "Basket for given id does not exist."),
    PRODUCT_NOT_FOUND_IN_CATALOG(HttpStatus.NOT_FOUND, "Catalog does not contain product with given id."),
    PRODUCT_NOT_FOUND_IN_BASKET(HttpStatus.NOT_FOUND, "Basket does not contain product with given id.");


    private final HttpStatus status;

    private final String message;

    ErrorReason(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
