package com.Baranov.demo.fleamarket.controller;

import com.Baranov.demo.fleamarket.service.ItemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Mono<Rendering> getAllItems() {
        return itemService.findAll()
                .collectList()
                .map(items -> Rendering.view("items/list")
                        .modelAttribute("items", items)
                        .build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public Mono<Rendering> deleteItem(@PathVariable String id) {
        return itemService.deleteById(id)
                .thenReturn(Rendering.redirectTo("/items").build());
    }
}
