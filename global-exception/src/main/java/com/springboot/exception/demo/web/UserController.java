package com.springboot.exception.demo.web;

import com.springboot.exception.demo.model.entity.User;
import com.springboot.exception.demo.model.entity.ValidatorGroup1;
import lombok.AllArgsConstructor;
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
    public List<ObjectError> addUser(@Validated(ValidatorGroup1.class) @RequestBody User user) {

        return null;
    }
}
