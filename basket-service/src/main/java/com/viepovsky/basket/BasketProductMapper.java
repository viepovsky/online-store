package com.viepovsky.basket;

import com.viepovsky.basket.Basket.Product;
import com.viepovsky.basket.dto.AddProductRequest;
import com.viepovsky.basket.dto.ProductResponse;
import com.viepovsky.basket.dto.UpdateProductRequest;
import org.springframework.stereotype.Component;

@Component
class BasketProductMapper {
    Product mapToProduct(UpdateProductRequest request) {
        return new Product(
                request.getProductId(),
                request.getQuantityChange()
        );
    }

    Product mapToProduct(AddProductRequest request) {
        return new Product(
                request.getProductId(),
                request.getQuantity()
        );
    }

    ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(
                product.getProductId(),
                product.getQuantity()
        );
    }
}
