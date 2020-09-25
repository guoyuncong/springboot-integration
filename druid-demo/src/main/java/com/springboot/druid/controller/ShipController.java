package com.springboot.druid.controller;

import com.springboot.druid.service.ShipService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ship")
@AllArgsConstructor
public class ShipController {

    private final ShipService shipService;

    @GetMapping("list")
    public void list() {
        shipService.list();
    }
}
