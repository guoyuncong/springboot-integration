package com.hibernate.validator.model.entity;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author: yagena
 * @date: 2020-11-11
 */
@Data
public class User {

    private Integer id;

    @Size(min = 5, max = 10, message = "用户名长度介于{min}到{max}个字符之间")
    private String name;

    @NotNull(message = "用户地址不能为空")
    private String address;

    @DecimalMin(value = "1", message = "年龄输入错误")
    @DecimalMax(value = "200", message = "年龄输入错误")
    private Integer age;
}
