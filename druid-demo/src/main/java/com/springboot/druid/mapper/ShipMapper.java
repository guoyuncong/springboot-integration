package com.springboot.druid.mapper;

import com.springboot.druid.model.entity.Ship;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShipMapper {

    List<Ship> list(@Param("id") String id);
}
