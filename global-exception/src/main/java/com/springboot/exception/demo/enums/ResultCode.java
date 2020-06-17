package com.springboot.exception.demo.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResultCode {
    SUCCESS("000000", "请求成功"),
    INTERNAL_SERVER_ERROR("A0500", "系统异常,请联系管理员"),
    PARAMETER_ERROR("A0400", "请求参数错误"),
    ;
    private String code;

    private String message;
}
