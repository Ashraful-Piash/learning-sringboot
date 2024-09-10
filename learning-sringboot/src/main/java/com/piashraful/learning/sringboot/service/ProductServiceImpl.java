package com.piashraful.learning.sringboot.service;

import com.piashraful.learning.sringboot.entity.Product;
import com.piashraful.learning.sringboot.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> fetchProductById(Long productId) {
        return productRepository.findByProductIdAndIsActiveTrue(productId);
    }

    @Override
    public void deleteProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();  // Retrieve the Product
            product.setIsActive(false);               // Set isActive to false
            productRepository.save(product);          // Save the updated Product
        } else {
            throw new EntityNotFoundException("Product not found with id: " + productId);
        }
    }
}
