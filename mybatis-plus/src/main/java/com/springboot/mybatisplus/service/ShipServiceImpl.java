package com.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.mybatisplus.mapper.ShipMapper;
import com.springboot.mybatisplus.model.entity.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {

    @Autowired
    private  ShipMapper shipMapper;

    @Override
    public Page<Ship> list() {
        Page page = new Page(1, 10);
        LambdaQueryWrapper<Ship> shipLambdaQueryWrapper = new LambdaQueryWrapper<>();
        shipLambdaQueryWrapper.eq(Ship::getName, "");
        return shipMapper.selectPage(page, shipLambdaQueryWrapper);
    }
}
