package com.viepovsky.basket;

import com.viepovsky.basket.Basket.Product;
import org.springframework.stereotype.Component;

@Component
class BasketProductMapper {
    Product mapToProduct(BasketProductRequest request) {
        return new Product(
                request.getProductId(),
                request.getQuantity()
        );
    }
}
