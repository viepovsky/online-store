package com.viepovsky.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    PENDING("Payment is pending"),
    PROCESSING("Payment is being processed"),
    COMPLETED("Payment has been completed successfully"),
    FAILED("Payment has failed"),
    CANCELED("Payment has been canceled");

    private final String description;
}
