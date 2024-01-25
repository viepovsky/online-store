package com.viepovsky.catalog;

import com.viepovsky.catalog.dto.AddProductRequest;
import org.springframework.stereotype.Component;

@Component
class ProductMapper {
    Product mapToProduct(AddProductRequest request) {
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getModel(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getStockQuantity(),
                request.getImageUrl(),
                request.getProperties()
        );
    }
}
