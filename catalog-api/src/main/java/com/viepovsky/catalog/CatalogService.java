package com.viepovsky.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CatalogService {

    private final ProductMapper productMapper;

    void addProduct(AddProductRequest request) {
        Product product = productMapper.mapToProduct(request);
        //product save
    }
}
