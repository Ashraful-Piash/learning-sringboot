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
        try {
            return Optional.ofNullable(productRepository.findByProductIdAndIsActiveTrue(productId)
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId)));
        } catch (EntityNotFoundException e) {
            return Optional.empty();
        }
    }


    @Override
    public void deleteProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setIsActive(false);
            productRepository.save(product);
        } else {
            throw new EntityNotFoundException("Product not found with id: " + productId);
        }
    }

    @Override
    public String getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }
}
