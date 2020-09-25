package com.springboot.security.model.param;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StudentParam {

    @NotBlank(message = "姓名不能为空")
    @Size(max = 3, message = "姓名最大长度为 20")
    private String name;

    @NotNull
    private Integer age;
}
