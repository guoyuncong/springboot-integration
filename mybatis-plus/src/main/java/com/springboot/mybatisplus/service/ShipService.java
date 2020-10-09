package com.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.mybatisplus.model.entity.Ship;

public interface ShipService {
    Page<Ship> list();
}
