package com.Baranov.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import com.Baranov.demo.models.Seller;

@RestController
@RequestMapping("/api/sellers/list")
public class SellerListController {
    private final List<Seller> sellers = new ArrayList<>();

    public SellerListController() {
        sellers.add(new Seller(1L, "Oleksandr Baranov", 21, 4.5f));
        sellers.add(new Seller(1L, "Sergey Kozlov", 18, 4.2f));
    }

    @GetMapping
    public List<Seller> getAllProducts() {
        return sellers;
    }
    @GetMapping("/")
    public String homePage() {
        return "index";
    }
}
