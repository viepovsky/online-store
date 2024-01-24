package com.viepovsky.basket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("baskets")
class Basket {

    @Id
    private String userId;

    private List<Product> products;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Product {
        private String productId;
        private Long quantity;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product that = (Product) o;
            return Objects.equals(productId, that.productId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(productId);
        }
    }
}


