package com.viepovsky.order.dto;

import com.viepovsky.order.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        String userId,
        List<ProductResponse> products,
        BigDecimal totalPrice,
        PaymentStatus paymentStatus,
        LocalDateTime paymentDate
) {
}
