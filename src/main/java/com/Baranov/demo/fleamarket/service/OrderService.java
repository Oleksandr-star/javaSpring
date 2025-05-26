package com.Baranov.demo.fleamarket.service;

import com.Baranov.demo.fleamarket.model.Order;
import com.Baranov.demo.fleamarket.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Mono<Order> createOrder(Order order) {
        return orderRepo.save(order);
    }

    public Flux<Order> getOrdersByBuyer(String buyerId) {
        return orderRepo.findByBuyerId(buyerId);
    }

    public Mono<Order> getOrderById(String id) {
        return orderRepo.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Order not found with id: " + id)));
    }

    public Mono<Void> deleteOrder(String id) {
        return orderRepo.deleteById(id);
    }
}