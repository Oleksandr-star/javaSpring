package com.Baranov.demo.models;

public record Product(
        Long id,
        String name,
        String category,
        String description,
        Double price,
        Integer stock
) {}