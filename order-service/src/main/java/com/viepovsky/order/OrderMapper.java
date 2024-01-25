package com.viepovsky.order;

import com.viepovsky.order.dto.OrderResponse;
import com.viepovsky.order.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
class OrderMapper {
    OrderResponse mapToOrderResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getProducts()
                     .stream()
                     .map(this::mapToProductResponse)
                     .toList(),
                order.getTotalPrice(),
                order.getPaymentStatus(),
                order.getPaymentDate()
        );
    }

    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(
                product.getProductId(),
                product.getName(),
                product.getBrand(),
                product.getModel(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}
