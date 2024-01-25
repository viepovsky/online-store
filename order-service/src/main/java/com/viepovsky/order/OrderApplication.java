package com.viepovsky.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository) {
        return args -> {
            Product product = Product.builder()
                                     .productId("id2")
                                     .name("prod_name")
                                     .brand("prod_brand")
                                     .price(BigDecimal.ONE)
                                     .quantity(50)
                                     .build();
            Product product2 = Product.builder()
                                      .productId("id4")
                                      .name("prod_name4")
                                      .brand("prod_brand4")
                                      .price(BigDecimal.valueOf(50))
                                      .quantity(5)
                                      .build();
            List<Product> products = List.of(product, product2);
            Order order = Order.builder()
                               .userId("1111")
                               .products(products)
                               .totalPrice(BigDecimal.valueOf(300))
                               .paymentStatus(PaymentStatus.PENDING)
                               .build();
            product.setOrder(order);
            product2.setOrder(order);
            orderRepository.save(order);
        };
    }
}
