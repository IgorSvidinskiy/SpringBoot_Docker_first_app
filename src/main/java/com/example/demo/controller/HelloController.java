package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello World from Spring Boot in Docker with MySQL!";
    }
    
    @GetMapping("/api/greet")
    public String greet() {
        return "Welcome to Spring Boot REST API!";
    }
    
    // Получить всех пользователей
    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Создать нового пользователя
    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    // Получить пользователя по ID
    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }
}