package com.viepovsky.catalog;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class AddProductRequest {

    @NotBlank(message = "Name must not be blank.")
    private String name;

    @NotBlank(message = "Brand must not be blank.")
    private String brand;

    @NotBlank(message = "Model must not be blank.")
    private String model;

    private String description;

    @NotNull(message = "Category must not be null.")
    private ProductCategory category;

    @DecimalMin(
            value = "0",
            message = "Price must be greater or equal to 0."
    )
    @NotNull(message = "Price must not be null.")
    private BigDecimal price;

    @Min(
            value = 1,
            message = "Quantity must be greater than 0."
    )
    @NotNull(message = "Quantity must not be null.")
    private Integer stockQuantity;

    private String imageUrl;

    private Map<String, String> properties;
}
