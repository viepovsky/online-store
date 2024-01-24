package com.viepovsky.catalog;

import com.viepovsky.catalog.dto.AddProductRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/catalog")
@RequiredArgsConstructor
@Validated
class CatalogController {

    private final CatalogService catalogService;

    @GetMapping
    ResponseEntity<Boolean> isProductInCatalog(@RequestParam(name = "product-id") @NotBlank String productID) {
        return ResponseEntity.ok(catalogService.isProductInCatalog(productID));
    }

    @PostMapping
    void addProduct(@Valid @RequestBody AddProductRequest request) {
        log.info("Adding new product to catalog {}", request);
        catalogService.addProduct(request);
    }
}
