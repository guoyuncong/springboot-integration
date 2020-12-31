package com.security.oauth2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yagena
 * @date: 2020-11-24
 */
@RestController
@AllArgsConstructor
public class ResController {

    @GetMapping("/res/{id}")
    public String testOauth(@PathVariable String id) {
        return "Get the resource " + id;
    }
}
