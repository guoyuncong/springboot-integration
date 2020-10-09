package com.springboot.mybatisplus.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("ship")
public class Ship {

    @TableId(type = IdType.ASSIGN_UUID)
    private String shipId;

    @TableField("name")
    private String name;

    private Date updatedBy;
}
