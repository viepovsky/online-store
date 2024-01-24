package com.viepovsky.open_feign_clients.catalog;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("catalog")
public interface CatalogClient {

    @GetMapping("api/v1/catalog")
    ResponseEntity<Boolean> isProductInCatalog(@RequestParam(name = "product-id") String productID);
}
