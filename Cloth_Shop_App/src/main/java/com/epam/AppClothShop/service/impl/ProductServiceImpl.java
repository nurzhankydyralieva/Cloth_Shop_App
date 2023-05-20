package com.epam.AppClothShop.service.impl;

import com.epam.AppClothShop.model.Product;
import com.epam.AppClothShop.repository.ProductRepository;
import com.epam.AppClothShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new RuntimeException("Product with id " + id + " not found");
    }

    @Override
    @Transactional
    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        return repository.save(product);
    }
}
