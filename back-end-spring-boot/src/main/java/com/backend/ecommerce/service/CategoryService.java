package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    String createNewCategory(Category category);
    String deleteCategory(Long theId);
}
