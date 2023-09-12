package com.backend.ecommerce.controller;

import com.backend.ecommerce.dto.ProductDTO;
import com.backend.ecommerce.entity.Product;
import com.backend.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get")
    public ResponseEntity<List> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/get/{theId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long theId) {
        Product product = productService.findById(theId);
        ProductDTO productDTO = productService.convertProductToDTO(product);
        return ResponseEntity.ok(productDTO);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createdProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createNewProduct(product));
    }
    @PutMapping("/update/{theId}")
    public ResponseEntity<Object> updateProductsById(@PathVariable Long theId, @RequestBody Product updatedProduct) {
        return ResponseEntity.ok(productService.updateProduct(theId ,updatedProduct));
    }
    @DeleteMapping("/delete{theId}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long theId) {
        return ResponseEntity.ok(productService.deleteById(theId));
    }
}
