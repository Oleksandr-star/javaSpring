package com.Baranov.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import com.Baranov.demo.models.Product;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "Laptop", "Electronics", "A powerful laptop", 1200.0, 5));
        products.add(new Product(2L, "Phone", "Electronics", "A modern smartphone", 800.0, 10));
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }
    @GetMapping("/")
    public String homePage() {
        return "index";
    }
}
