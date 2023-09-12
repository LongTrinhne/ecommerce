package com.backend.ecommerce.service;

import com.backend.ecommerce.dto.ProductDTO;
import com.backend.ecommerce.entity.Product;
import com.backend.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long theId) {
        return productRepository.findById(theId).orElseThrow(
                () -> new RuntimeException("Product not Exist"));
    }

    @Override
    public Object save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String deleteById(Long theId) {
        productRepository.deleteById(theId);
        return "Product with Id: " + theId + " has been deleted.";
    }

    @Override
    public String createNewProduct(Product product) {
        Product tmp = new Product();
        tmp.setId(0L);
        tmp.setTitle(product.getTitle());
        tmp.setPrice(product.getPrice());
        tmp.setDiscount(product.getDiscount());
        tmp.setDescription(product.getDescription());
        tmp.setCreatedAt(product.getCreatedAt());
        tmp.setUpdatedAt(product.getUpdatedAt());
        tmp.setCategory(product.getCategory());
        save(tmp);
        return "New product has been saved.";
    }

    @Override
    public Object updateProduct(Long theId, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(theId);
        if (existingProduct.isPresent()) {
            Product tmp = existingProduct.get();
            tmp.setTitle(updatedProduct.getTitle());
            tmp.setPrice(updatedProduct.getPrice());
            tmp.setDiscount(updatedProduct.getDiscount());
            tmp.setDescription(updatedProduct.getDescription());
            tmp.setCreatedAt(updatedProduct.getCreatedAt());
            tmp.setUpdatedAt(updatedProduct.getUpdatedAt());
            tmp.setCategory(updatedProduct.getCategory());
            return productRepository.save(tmp);
        }
        else throw new RuntimeException("Product not Exist");
    }

    @Override
    public ProductDTO convertProductToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setPrice(product.getPrice());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }
}
