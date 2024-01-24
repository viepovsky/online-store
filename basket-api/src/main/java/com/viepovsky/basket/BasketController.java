package com.viepovsky.basket;

import com.viepovsky.basket.Basket.Product;
import com.viepovsky.basket.dto.AddProductRequest;
import com.viepovsky.basket.dto.UpdateProductRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/basket")
@RequiredArgsConstructor
@Validated
class BasketController {

    private final BasketService basketService;

    @GetMapping
    ResponseEntity<List<Product>> getAllProducts(@RequestParam(name = "user-id") @NotBlank String userID) {
        List<Product> products = basketService.getAllProducts(userID);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    void addProduct(
            @RequestParam(name = "user-id") @NotBlank String userID,
            @RequestBody @Valid AddProductRequest request
    ) {
        basketService.addProduct(userID, request);
    }

    @PutMapping
    void updateProduct(
            @RequestParam(name = "user-id") @NotBlank String userID,
            @RequestBody @Valid UpdateProductRequest request
    ) {
        basketService.updateProduct(userID, request);
    }
}
