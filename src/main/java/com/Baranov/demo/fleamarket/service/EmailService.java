//package com.Baranov.demo.fleamarket.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Mono;
//import reactor.core.scheduler.Schedulers;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Value("${app.admin.email:oleksandriob705@gmail.com}")
//    private String adminEmail;
//
//    public Mono<Void> sendLogEmail(String logMessage) {
//        return Mono.fromRunnable(() -> {
//                    SimpleMailMessage message = new SimpleMailMessage();
//                    message.setTo(adminEmail);
//                    message.setSubject("Application Log");
//                    message.setText(logMessage);
//                    mailSender.send(message);
//                })
//                .subscribeOn(Schedulers.boundedElastic())
//                .doOnError(e -> {
//                    System.err.println("Помилка відправки листа: " + e.getMessage());
//                })
//                .onErrorResume(e -> Mono.empty())
//                .then();
//    }
//}
