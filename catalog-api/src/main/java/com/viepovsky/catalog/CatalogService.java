package com.viepovsky.catalog;

import com.viepovsky.catalog.dto.AddProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CatalogService {

    private final ProductMapper productMapper;

    private final CatalogRepository catalogRepository;

    void addProduct(AddProductRequest request) {
        Product product = productMapper.mapToProduct(request);
        catalogRepository.save(product);
    }

    boolean isProductInCatalog(String productID) {
        return catalogRepository.existsById(productID);
    }
//
//    void addProduct(Product product) {
//        catalogRepository.save(product);
//    }
}
