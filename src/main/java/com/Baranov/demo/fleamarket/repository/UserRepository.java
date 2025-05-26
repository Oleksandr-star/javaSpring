package com.Baranov.demo.fleamarket.repository;

import com.Baranov.demo.fleamarket.model.AppUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<AppUser, String> {
    Mono<AppUser> findByUsername(String username);
}