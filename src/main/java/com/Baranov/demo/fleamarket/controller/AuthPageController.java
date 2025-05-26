package com.Baranov.demo.fleamarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/auth")
public class AuthPageController {

    @GetMapping("/login")
    public Mono<String> loginPage() {
        return Mono.just("auth/login");
    }
    @GetMapping("/register")
    public Mono<String> registerPage() {
        return Mono.just("auth/register");
    }
    @GetMapping("/test")
    public Mono<String> testPage() {
        return Mono.just("auth/test");
    }
}
