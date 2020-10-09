package com.springboot.mybatisplus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.mybatisplus.model.entity.Ship;
import com.springboot.mybatisplus.service.ShipService;
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
        Page<Ship> shipPage = shipService.list();
    }
}
