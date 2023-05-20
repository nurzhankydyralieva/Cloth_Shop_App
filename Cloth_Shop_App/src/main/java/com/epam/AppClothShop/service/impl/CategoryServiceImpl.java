package com.epam.AppClothShop.service.impl;

import com.epam.AppClothShop.model.Category;
import com.epam.AppClothShop.repository.CategoryRepository;
import com.epam.AppClothShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getAllCategory() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = repository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        throw new RuntimeException("Category with id " + id + " not found");
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Category updateCategory(Category category) {
        return repository.save(category);
    }
}
