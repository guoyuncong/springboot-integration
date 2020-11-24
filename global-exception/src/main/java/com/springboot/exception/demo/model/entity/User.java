package com.springboot.exception.demo.model.entity;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: yagena
 * @date: 2020-11-11
 */
@Data
public class User {

    private Integer id;

    @Size(min = 5, max = 10, message = "用户名长度介于{min}到{max}个字符之间", groups = ValidatorGroup1.class)
    private String name;

    @NotNull(message = "用户地址不能为空", groups = ValidatorGroup1.class)
    private String address;

    @DecimalMin(value = "1", message = "年龄输入错误", groups = ValidatorGroup2.class)
    @DecimalMax(value = "200", message = "年龄输入错误", groups = ValidatorGroup2.class)
    private Integer age;
}
