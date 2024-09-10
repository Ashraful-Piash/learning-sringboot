package com.piashraful.learning.sringboot.service;

import com.piashraful.learning.sringboot.entity.Product;

import java.util.List;

public interface ProductService {
   public Product saveProduct(Product product);

   public List<Product> getAllProducts();

    public Product fetchProductById(Long productId);
}
