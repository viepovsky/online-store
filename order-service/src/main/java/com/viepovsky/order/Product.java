package com.viepovsky.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "product")
class Product {

    @Id
    private String id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "brand",
            nullable = false
    )
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(
            name = "price",
            nullable = false
    )
    private BigDecimal price;

    @Column(
            name = "total_price",
            nullable = false
    )
    private BigDecimal totalPrice;

    @Column(
            name = "quantity",
            nullable = false
    )
    private Integer quantity;

    Product(String name,
            String brand,
            String model,
            BigDecimal price,
            BigDecimal totalPrice,
            Integer quantity) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }
}
