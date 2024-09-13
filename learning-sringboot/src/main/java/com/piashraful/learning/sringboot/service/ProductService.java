package com.piashraful.learning.sringboot.service;

import com.piashraful.learning.sringboot.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
   public Product saveProduct(Product product);

   public List<Product> getAllProducts();

   public Optional<Product> fetchProductById(Long productId);

   public void deleteProductById(Long productId);

   public String  getProductByName(String productName);
}
