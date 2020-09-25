package com.springboot.druid.service;

import com.springboot.druid.mapper.ShipMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ShipServiceImpl implements ShipService {

    private final ShipMapper shipMapper;

    @Override
    public void list() {
        shipMapper.list("aaaaa");
    }
}
