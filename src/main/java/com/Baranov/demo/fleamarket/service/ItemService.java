package com.Baranov.demo.fleamarket.service;

import com.Baranov.demo.fleamarket.model.Item;
import com.Baranov.demo.fleamarket.repository.ItemRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemService {
    private final ItemRepository itemRepo;

    public ItemService(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Flux<Item> findAll() {
        return itemRepo.findAll();
    }

    public Mono<Item> findById(String id) {
        return itemRepo.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Item not found with id: " + id)));
    }

    public Flux<Item> findByTitle(String title) {
        return itemRepo.findByTitle(title);
    }

    public Flux<Item> findByKeyword(String keyword) {
        return itemRepo.findByTitleContainingIgnoreCase(keyword);
    }

    public Flux<Item> findByPriceRange(double minPrice, double maxPrice) {
        return itemRepo.findByPriceBetween(minPrice, maxPrice);
    }

    public Flux<Item> findAvailableItems(boolean isAvailable) {
        return itemRepo.findAvailableItems(isAvailable);
    }

    public Mono<Item> save(Item item) {
        return itemRepo.save(item);
    }

    public Mono<Void> deleteById(String id) {
        return itemRepo.deleteById(id);
    }
}
