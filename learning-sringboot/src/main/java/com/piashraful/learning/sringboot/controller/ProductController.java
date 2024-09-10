package com.piashraful.learning.sringboot.controller;


import com.piashraful.learning.sringboot.entity.Product;
import com.piashraful.learning.sringboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product fetchProductById(@PathVariable ("id") Long productId) {
        return productService.fetchProductById(productId);
    }


}
