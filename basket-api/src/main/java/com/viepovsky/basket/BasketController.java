package com.viepovsky.basket;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/basket")
@RequiredArgsConstructor
@Validated
class BasketController {

    private final BasketService basketService;

    @PostMapping
    void addProduct(
            @RequestParam(name = "user-id") @NotBlank String userId,
            @RequestBody @Valid BasketProductRequest request
    ) {
        basketService.addProduct(userId, request);
    }
}
