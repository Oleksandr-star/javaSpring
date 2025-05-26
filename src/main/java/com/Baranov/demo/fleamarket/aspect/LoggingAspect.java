//package com.Baranov.demo.fleamarket.aspect;
//
//import com.Baranov.demo.fleamarket.config.LogWebSocketHandler;
//import com.Baranov.demo.fleamarket.service.EmailService;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggingAspect {
//
//    private final LogWebSocketHandler wsHandler;
//    private final EmailService emailService;
//
//    public LoggingAspect(LogWebSocketHandler wsHandler, EmailService emailService) {
//        this.wsHandler = wsHandler;
//        this.emailService = emailService;
//    }
//
//    @Around(
//            "execution(* com.Baranov.demo.fleamarket..*(..))" +
//                    " && !within(com.Baranov.demo.fleamarket.config..*)" +
//                    " && !within(com.Baranov.demo.fleamarket.service.EmailService)"
//    )
//    public Object logMethod(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object result = pjp.proceed();
//        long duration = System.currentTimeMillis() - start;
//
//        String message = String.format("%s executed in %d ms", pjp.getSignature(), duration);
//
//        wsHandler.sendLog(message);
//
//        emailService.sendLogEmail(message).subscribe();
//
//        return result;
//    }
//}
