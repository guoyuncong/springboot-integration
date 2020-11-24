package com.hibernate.validator.controller;

import com.hibernate.validator.model.entity.User;
import com.hibernate.validator.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: yagena
 * @date: 2020-11-12
 */
@RestController
@AllArgsConstructor
public class UserController {

    @PostMapping("save")
    public List<ObjectError> addUser(@Validated @RequestBody User user) {

        return null;
    }
}
