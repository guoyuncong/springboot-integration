package com.springboot.startup.postconstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PostConstructDemo {

    @Autowired
    private XConfiguration xConfiguration;

    @PostConstruct
    public void init() {
        System.out.println("init ....");
    }

    public PostConstructDemo() {
        System.out.println("PostConstructDemo constructor() ...");
    }
}
