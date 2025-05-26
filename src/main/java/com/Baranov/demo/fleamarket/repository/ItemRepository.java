package com.Baranov.demo.fleamarket.repository;

import com.Baranov.demo.fleamarket.model.Item;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemRepository extends ReactiveMongoRepository<Item, String> {

    Flux<Item> findByTitle(String title);

    Flux<Item> findByTitleContainingIgnoreCase(String keyword);

    Flux<Item> findByPriceLessThanEqual(double maxPrice);

    Flux<Item> findBySellerId(String sellerId);

    @Query("{ 'price' : { $gte: ?0, $lte: ?1 } }")
    Flux<Item> findByPriceBetween(double minPrice, double maxPrice);

    @Query("{ 'available' : ?0 }")
    Flux<Item> findAvailableItems(boolean isAvailable);

    @Override
    Mono<Item> findById(String id);
}