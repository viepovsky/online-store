package com.viepovsky.catalog;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class AddProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    private String description;

    @NotBlank
    private ProductCategory category;

    @DecimalMin("0")
    private BigDecimal price;

    @Min(0)
    private Integer stockQuantity;

    private String imageUrl;

    private Map<String, String> properties;
}
