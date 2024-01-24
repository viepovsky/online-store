package com.viepovsky.basket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
class BasketService {

    private final BasketRepository basketRepository;

    void addProductToBasket(String userID, Basket.BasketProduct product) {
        Basket basket = basketRepository.findById(userID).orElseThrow(() -> new RuntimeException("Basket of id:" + userID + " not found."));
        //TODO: Request to Catalog if given productId exists.
        basket.getProducts().add(product);
        basketRepository.save(basket);
    }

    void updateProduct(String userID, Basket.BasketProduct product) {
        Basket basket = basketRepository.findById(userID).orElseThrow(() -> new RuntimeException("Basket of id:" + userID + " not found."));
        //TODO: Request to Catalog if given productId exists.
        HashSet<Basket.BasketProduct> products = basket.getProducts();
        products.stream()
                .filter(basketProduct -> basketProduct.equals(product))
                .findFirst()
                .ifPresentOrElse(
                        basketProduct -> {
                            long newQuantity = basketProduct.getQuantity() + product.getQuantity();
                            if (newQuantity <= 0) {
                                products.remove(product);
                            } else {
                                basketProduct.setQuantity(newQuantity);
                            }
                        },
                        () -> new RuntimeException("Basket does not contain product of id:" + product.getProductId())
                );
        basketRepository.save(basket);
    }
}
