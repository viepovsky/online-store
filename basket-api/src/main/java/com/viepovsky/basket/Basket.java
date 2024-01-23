package com.viepovsky.basket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("baskets")
class Basket {

    @Id
    private String userId;

    private HashSet<BasketProduct> products;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class BasketProduct {
        private String productId;
        private Long quantity;
    }
}


