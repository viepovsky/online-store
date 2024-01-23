package com.viepovsky.catalog;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Product {
    private Long id;
    private String name;
    private String brand;
    private String model;
    private String description;
    private ProductCategory category;
    private BigDecimal price;
    private Integer stockQuantity;
    private String imageUrl;
    private Map<String, String> properties;

    Product(String name,
            String brand,
            String model,
            String description,
            ProductCategory category,
            BigDecimal price,
            Integer stockQuantity,
            String imageUrl,
            Map<String, String> properties) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
        this.properties = properties;
    }
}
