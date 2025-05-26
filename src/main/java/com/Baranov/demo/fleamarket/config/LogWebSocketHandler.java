package com.Baranov.demo.fleamarket.config;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.WebSocketMessage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Set;

@Component
public class LogWebSocketHandler implements WebSocketHandler {

    private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
    private final Sinks.Many<String> sink = Sinks.many().multicast().onBackpressureBuffer();

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        sessions.add(session);
        Flux<WebSocketMessage> outbound = sink.asFlux()
                .map(session::textMessage)
                .onErrorContinue((throwable, o) -> {
                    System.err.println("Помилка під час відправки повідомлення: " + throwable.getMessage());
                });

        return session.send(outbound)
                .doFinally(sig -> sessions.remove(session))
                .onErrorResume(e -> {
                    System.err.println("Помилка WebSocket сесії: " + e.getMessage());
                    return Mono.empty();
                });
    }

    public void sendLog(String message) {
        Sinks.EmitResult result = sink.tryEmitNext(message);
        if (result.isFailure()) {
            System.err.println("Не вдалося надіслати лог: " + result.name());
        }
    }
}