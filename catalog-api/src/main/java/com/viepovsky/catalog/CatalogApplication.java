package com.viepovsky.catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CatalogApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatalogApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CatalogService catalogService) {
        return  args -> {
            //checkAdd(catalogService);
        };
    }

    private void checkAdd(CatalogService catalogService) {
        Product product = Product.builder().brand("BRANDDD").model("modelHere").category(ProductCategory.AUTOMOTIVE).name("namehere").imageUrl("imageurl").price(BigDecimal.ONE).build();
        Product product2 = Product.builder().brand("BRANDDD2").model("modelHere2").category(ProductCategory.AUTOMOTIVE).name("namehere2").imageUrl("imageurl2").price(BigDecimal.ONE).build();

//        catalogService.addProduct(product);
//        catalogService.addProduct(product2);
    }
}
