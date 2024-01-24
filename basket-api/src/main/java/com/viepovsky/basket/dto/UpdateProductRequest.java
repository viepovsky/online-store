package com.viepovsky.basket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateProductRequest {

    @NotBlank(message = "ProductId must not be blank.")
    private String productId;

    @NotNull(message = "Quantity must not be null.")
    private Integer quantityChange;
}
