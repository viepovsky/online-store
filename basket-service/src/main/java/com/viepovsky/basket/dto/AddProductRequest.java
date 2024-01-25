package com.viepovsky.basket.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddProductRequest {

    @NotBlank(message = "ProductId must not be blank.")
    private String productId;

    @Min(
            value = 1,
            message = "Quantity must be greater than 0."
    )
    @NotNull(message = "Quantity must not be null.")
    private Long quantity;
}
