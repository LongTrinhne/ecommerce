package com.backend.ecommerce.controller;

import com.backend.ecommerce.entity.Category;
import com.backend.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get")
    public ResponseEntity<List> getAllCategory() {
        return ResponseEntity.ok(categoryService.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<String> createNewCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createNewCategory(category));
    }
    @DeleteMapping("/delete/{theId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long theId) {
        return ResponseEntity.ok(categoryService.deleteCategory(theId));
    }
}
