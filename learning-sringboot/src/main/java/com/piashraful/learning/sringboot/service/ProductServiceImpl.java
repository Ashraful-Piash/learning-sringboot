package com.piashraful.learning.sringboot.service;

import com.piashraful.learning.sringboot.entity.Product;
import com.piashraful.learning.sringboot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

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
    public Product fetchProductById(Long productId) {
        return productRepository.findById(productId).get();
    }
}
