package com.piashraful.learning.sringboot.controller;


import com.piashraful.learning.sringboot.dto.AuthRequest;
import com.piashraful.learning.sringboot.entity.Product;
import com.piashraful.learning.sringboot.service.JwtService;
import com.piashraful.learning.sringboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;


    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/products/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
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

    @GetMapping("/product/name")
    public String getProductByName(@PathVariable("name") String productName) {
       return productService.getProductByName(productName);
    }

    @PostMapping("/authenticate")
    public String getToken(@RequestBody AuthRequest authRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUserName());
        }else {
            throw  new UsernameNotFoundException("Invalid username or password");
        }

    }

    @GetMapping("/test")
    public String test (){
        return "This is a test for security";
    }


}
