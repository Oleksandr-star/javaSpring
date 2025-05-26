package com.Baranov.demo.fleamarket.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "items")
@Data
public class Item {
    @Id
    private String id;

    @NotBlank(message = "Title must not be blank")
    private String title;

    @Size(max = 500, message = "Description must be at most 500 characters")
    private String description;

    @Positive(message = "Price must be positive")
    private double price;

    private String sellerId;

    private LocalDateTime createdAt = LocalDateTime.now();

    private boolean available = true;
}
