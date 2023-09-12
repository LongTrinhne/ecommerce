package com.backend.ecommerce.service;

import com.backend.ecommerce.entity.Category;
import com.backend.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public String createNewCategory(Category category) {
        Category tmp = new Category();
        tmp.setId(0L);
        tmp.setName(category.getName());
        tmp.setProduct(category.getProduct());
        categoryRepository.save(tmp);
        return "New category has been saved.";
    }

    @Override
    public String deleteCategory(Long theId) {
        categoryRepository.deleteById(theId);
        return "Category with Id: " + theId + " has been deleted.";
    }
}
