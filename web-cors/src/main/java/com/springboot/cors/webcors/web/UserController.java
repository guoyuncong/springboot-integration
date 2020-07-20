package com.springboot.cors.webcors.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @PostMapping("/")
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String addUser(String name) {
        return "add " + name;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return "delete id";
    }
}
