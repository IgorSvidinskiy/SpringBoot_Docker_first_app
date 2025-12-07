package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello World from Spring Boot in Docker!";
    }
    
    @GetMapping("/api/greet")
    public String greet() {
        return "Welcome to Spring Boot REST API!";
    }
}
