package com.viepovsky.basket;

import com.viepovsky.basket.Basket.Product;
import com.viepovsky.basket.dto.AddProductRequest;
import com.viepovsky.basket.dto.UpdateProductRequest;
import com.viepovsky.open_feign_clients.catalog.CatalogClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class BasketService {

    private final BasketRepository basketRepository;

    private final BasketProductMapper basketProductMapper;

    private final CatalogClient catalogClient;

    List<Product> getAllProducts(String userID) {
        Basket basket = basketRepository.findById(userID).orElseThrow(() -> new RuntimeException("Basket of id:" + userID + " not found."));
        return basket.getProducts();
    }

    void addProduct(String userID, AddProductRequest request) {
        Product product = basketProductMapper.mapToProduct(request);
        ResponseEntity<Boolean> response = catalogClient.isProductInCatalog(product.getProductId());
        if (Boolean.FALSE.equals(response.getBody()))
            throw new RuntimeException("Product of given id:" + product.getProductId() + " does not exist.");
        Basket basket = basketRepository.findById(userID).orElse(new Basket(userID, new ArrayList<>()));
        //TODO: Request to Catalog if given productId exists.
        List<Product> basketProducts = basket.getProducts();
        basketProducts.remove(product);
        basketProducts.add(product);
        basketRepository.save(basket);
    }

    void updateProduct(String userID, UpdateProductRequest request) {
        Basket basket = basketRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Basket of id:" + userID + " not found."));
        Product product = basketProductMapper.mapToProduct(request);
        long quantityChange = product.getQuantityChange();
        //TODO: Request to Catalog if given productId exists.
        List<Product> basketProducts = basket.getProducts();
        basketProducts.stream()
                .filter(basketProduct -> basketProduct.equals(product))
                .findFirst()
                .map(basketProduct -> {
                    long newQuantity = basketProduct.getQuantity() + quantityChange;
                    if (newQuantity <= 0) {
                        basketProducts.remove(product);
                    } else {
                        basketProduct.setQuantity(newQuantity);
                    }
                    return basketProduct;
                })
                .orElseThrow(() -> new RuntimeException("Basket does not contain product of id:" + product.getProductId()));

        basketRepository.save(basket);
    }
}
