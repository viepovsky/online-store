package com.viepovsky.basket;

import com.viepovsky.basket.Basket.Product;
import com.viepovsky.basket.dto.AddProductRequest;
import com.viepovsky.basket.dto.ProductResponse;
import com.viepovsky.basket.dto.UpdateProductRequest;
import com.viepovsky.open_feign_clients.catalog.CatalogClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class BasketService {

    private final BasketRepository basketRepository;

    private final BasketProductMapper basketProductMapper;

    private final CatalogClient catalogClient;

    List<ProductResponse> getAllProducts(String userID) {
        List<Product> products = new ArrayList<>();
        basketRepository.findById(userID)
                        .ifPresent(basket -> products.addAll(basket.getProducts()));

        return products.stream()
                       .map(basketProductMapper::mapToProductResponse)
                       .toList();
    }

    void addProduct(String userID, AddProductRequest request) {
        checkIfProductExistsInCatalogOrThrow(request.getProductId());
        Product productToAdd = basketProductMapper.mapToProduct(request);
        Basket basket = getBasketOrCreateNew(userID);
        removeThenAddProductToBasketAndSave(basket, productToAdd);
    }

    private void checkIfProductExistsInCatalogOrThrow(String productID) {
        boolean exists = checkIfProductExistsInCatalog(productID);
        throwIfProductDoesNotExist(exists, productID);

    }

    private void throwIfProductDoesNotExist(boolean exists, String productID) {
        if (!exists)
            throw new RuntimeException("Product of given id:" + productID + " does not exist.");
    }

    private boolean checkIfProductExistsInCatalog(String productId) {
        ResponseEntity<Boolean> response = catalogClient.isProductInCatalog(productId);
        return Optional.ofNullable(response.getBody())
                       .orElse(false);
    }

    private Basket getBasketOrCreateNew(String userID) {
        return basketRepository.findById(userID)
                               .orElse(new Basket(userID, new ArrayList<>()));
    }

    private void removeThenAddProductToBasketAndSave(Basket basket, Product product) {
        List<Product> basketProducts = basket.getProducts();
        basketProducts.remove(product);
        basketProducts.add(product);
        basketRepository.save(basket);
    }

    void updateProduct(String userID, UpdateProductRequest request) {
        Basket basket = getBasketOrThrow(userID);
        Product product = basketProductMapper.mapToProduct(request);
        updateProductInBasketAndSave(basket, product);
    }

    private Basket getBasketOrThrow(String userID) {
        return basketRepository.findById(userID)
                               .orElseThrow(
                                       () -> new RuntimeException("Basket of id:" + userID + " not found. " +
                                               "Please add products by using POST instead of PUT request.")
                               );
    }

    private void updateProductInBasketAndSave(Basket basket, Product product) {
        long quantityChange = product.getQuantityChange();

        basket.getProducts()
              .stream()
              .filter(productInBasket -> productInBasket.equals(product))
              .findFirst()
              .map(productInBasket -> {
                  long newQuantity = productInBasket.getQuantity() + quantityChange;
                  if (newQuantity <= 0) {
                      basket.getProducts()
                            .remove(product);
                  } else {
                      productInBasket.setQuantity(newQuantity);
                  }
                  return productInBasket;
              })
              .orElseThrow(
                      () -> new RuntimeException("Basket does not contain product of id:" + product.getProductId() +
                              "Please add products by using POST instead of PUT request.")
              );

        basketRepository.save(basket);
    }
}
