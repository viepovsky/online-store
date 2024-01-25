package com.viepovsky.order;

import com.viepovsky.order.audit.BaseEntityAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
class Product extends BaseEntityAudit {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private String id;

    @Column(
            name = "product_id",
            nullable = false
    )
    private String productId;

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
            name = "quantity",
            nullable = false
    )
    private Integer quantity;

    @ManyToOne
    @JoinColumn(
            name = "order_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "product_order_id_fk")
    )
    private Order order;

    Product(String name,
            String brand,
            String model,
            BigDecimal price,
            Integer quantity) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }
}
