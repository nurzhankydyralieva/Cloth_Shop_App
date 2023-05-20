package com.epam.AppClothShop.service;

import com.epam.AppClothShop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product createProduct(Product product);

    Product getProductById(Long id);

    void deleteProductById(Long id);

    Product updateProduct(Product product);
}
