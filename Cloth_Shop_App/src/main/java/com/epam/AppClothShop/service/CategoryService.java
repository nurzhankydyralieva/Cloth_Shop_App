package com.epam.AppClothShop.service;

import com.epam.AppClothShop.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    Category createCategory(Category category);

    Category getCategoryById(Long id);

    void deleteCategory(Long id);

    Category updateCategory(Category category);

}
