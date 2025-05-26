package com.Baranov.demo.fleamarket.repository;

import com.Baranov.demo.fleamarket.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

    Flux<Order> findByBuyerId(String buyerId);

    Flux<Order> findByStatus(String status);

    Flux<Order> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);

}