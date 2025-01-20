package com.cog.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @PreAuthorize("hasRole('ADMIN')")
    public String createProduct() {
        return "Product Created";
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String viewProducts() {
        return "Viewing Products";
    }
}

