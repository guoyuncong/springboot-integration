package com.hibernate.validator.service;

import com.hibernate.validator.model.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yagena
 * @date: 2020-11-12
 */
@Service
public class UserServiceImpl implements UserService {




    @Transactional
    @Override
    public void addUser(User user) {

    }
}
