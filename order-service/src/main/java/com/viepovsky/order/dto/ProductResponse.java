package com.viepovsky.order.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String productId,
        String name,
        String brand,
        String model,
        BigDecimal price,
        Integer quantity
) {
}
