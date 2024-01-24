package com.viepovsky.basket;

import com.viepovsky.basket.Basket.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class BasketService {

    private final BasketRepository basketRepository;

    private final BasketProductMapper basketProductMapper;

    List<Product> getAllProducts(String userID) {
        Basket basket = basketRepository.findById(userID).orElseThrow(() -> new RuntimeException("Basket of id:" + userID + " not found."));
        return basket.getProducts();
    }

    void addProduct(String userID, BasketProductRequest request) {
        Product product = basketProductMapper.mapToProduct(request);
        Basket basket = basketRepository.findById(userID).orElse(new Basket(userID, new ArrayList<>()));
        //TODO: Request to Catalog if given productId exists.
        List<Product> basketProducts = basket.getProducts();
        basketProducts.remove(product);
        basketProducts.add(product);
        basketRepository.save(basket);
    }

    void updateProduct(String userID, BasketProductRequest request) {
        Basket basket = basketRepository.findById(userID).orElseThrow(() -> new RuntimeException("Basket of id:" + userID + " not found."));
        Product product = basketProductMapper.mapToProduct(request);
        //TODO: Request to Catalog if given productId exists.
        List<Product> basketProducts = basket.getProducts();
        basketProducts.stream()
                .filter(basketProduct -> basketProduct.equals(product))
                .findFirst()
                .map(basketProduct -> {
                    long newQuantity = basketProduct.getQuantity() + product.getQuantity();
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
