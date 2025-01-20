package com.cog.controller;

import com.cog.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public String createProduct() {
        return productService.createProduct();
    }

    @GetMapping("/products")
    public String viewProducts() {
        return productService.viewProducts();
    }
}

