package com.viepovsky.catalog;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
class Product {

    @Id
    private String id;

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
