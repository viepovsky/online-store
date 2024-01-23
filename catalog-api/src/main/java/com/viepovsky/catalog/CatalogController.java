package com.viepovsky.catalog;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/catalog")
@RequiredArgsConstructor
@Validated
class CatalogController {

    private final CatalogService catalogService;

    @PostMapping
    void addProduct(@Valid @RequestBody AddProductRequest request) {
        log.info("Adding new product to catalog {}", request);
        catalogService.addProduct(request);
    }
}
