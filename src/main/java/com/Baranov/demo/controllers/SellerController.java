package com.Baranov.demo.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    private final List<String> sellers = new ArrayList<>();
    public SellerController() {
        sellers.add("Seller 1");
        sellers.add("Seller 2");
    }
    @PostMapping
    public String registerSeller(@RequestBody String sellerName) {
        sellers.add(sellerName);
        return "Seller " + sellerName + " registered successfully!";
    }

    @PutMapping("/{index}")
    public String updateSeller(@PathVariable int index, @RequestBody String updatedName) {
        if (index >= 0 && index < sellers.size()) {
            sellers.set(index, updatedName);
            return "Seller updated successfully to: " + updatedName;
        } else {
            return "Seller not found!";
        }
    }

    @DeleteMapping("/{index}")
    public String deleteSeller(@PathVariable int index) {
        if (index >= 0 && index < sellers.size()) {
            String removedSeller = sellers.remove(index);
            return "Seller " + removedSeller + " deleted successfully!";
        } else {
            return "Seller not found!";
        }
    }

    @GetMapping
    public List<String> getAllSellers() {
        return sellers;
    }

    @GetMapping("/sellers")
    public String sellersPage() {
        return "sellers";
    }
}
