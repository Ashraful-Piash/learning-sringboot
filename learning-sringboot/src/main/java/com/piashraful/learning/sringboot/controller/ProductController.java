package com.piashraful.learning.sringboot.controller;


import com.piashraful.learning.sringboot.entity.Product;
import com.piashraful.learning.sringboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Product> fetchProductById(@PathVariable("id") Long productId) {
        Optional<Product> product = productService.fetchProductById(productId);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    @DeleteMapping("/product/{id}")
    public String deleteProductById(@PathVariable("id") Long productId) {
         productService.deleteProductById(productId);
         return "Product with id " + productId + " deleted successfully";
    }


}
