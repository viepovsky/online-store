package com.viepovsky.basket;

import com.viepovsky.basket.Basket.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("api/v1/basket")
@RequiredArgsConstructor
@Validated
class BasketController {

    private final BasketService basketService;

    @GetMapping
    ResponseEntity<HashSet<Product>> getAllProducts(@RequestParam(name = "user-id") @NotBlank String userID) {
        HashSet<Product> products = basketService.getAllProducts(userID);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    void addProduct(
            @RequestParam(name = "user-id") @NotBlank String userID,
            @RequestBody @Valid BasketProductRequest request
    ) {
        basketService.addProduct(userID, request);
    }
}
