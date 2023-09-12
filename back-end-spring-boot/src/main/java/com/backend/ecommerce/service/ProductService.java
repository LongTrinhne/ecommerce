package com.backend.ecommerce.service;

import com.backend.ecommerce.dto.ProductDTO;
import com.backend.ecommerce.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> findAll();
    Product findById(Long theId);
    Object save(Product product);
    String deleteById(Long theId);
    String createNewProduct(Product product);
    Object updateProduct(Long theId, Product updatedProduct);
    ProductDTO convertProductToDTO(Product product);
}
