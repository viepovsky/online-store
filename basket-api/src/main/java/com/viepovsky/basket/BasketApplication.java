package com.viepovsky.basket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.viepovsky.open_feign_clients"
)
public class BasketApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasketApplication.class, args);
    }
}
