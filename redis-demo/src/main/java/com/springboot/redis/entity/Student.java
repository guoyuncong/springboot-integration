package com.springboot.redis.entity;

import lombok.Data;

@Data
public class Student {

    /**
     * 主键 ID
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

}
