package com.springboot.startup.postconstruct;

import org.springframework.stereotype.Component;

@Component
public class XConfiguration {
    public XConfiguration() {
        System.out.println("XConfiguration constructor() ...");
    }
}
