package com.viepovsky.basket;

import com.viepovsky.open_feign_clients.exception_handling.GlobalHttpErrorHandler;
import com.viepovsky.open_feign_clients.exception_handling.ValidationBindExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {

    @Bean
    ValidationBindExceptionHandler validationBindExceptionHandler() {
        return new ValidationBindExceptionHandler();
    }

    @Bean
    GlobalHttpErrorHandler globalHttpErrorHandler() {
        return new GlobalHttpErrorHandler();
    }
}
