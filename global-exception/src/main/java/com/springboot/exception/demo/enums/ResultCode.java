package com.springboot.exception.demo.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author huawei
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResultCode {
    SUCCESS("00000", "请求成功"),

    USER_CLIENT_ERROR("A0001", "用户端错误"),
    USER_REGISTERED_ERROR("A0100", "用户注册错误"),
    USER_USERNAME_CHECK_ERROR("A0110", "用户名校验失败"),
    USER_USERNAME_HAS_EXISTED("A0111", "用户名已存在"),
    USER_USERNAME_CONTAINS_SENSITIVE_WORDS("A0112", "用户名包含敏感词"),
    USER_USERNAME_CONTAINS_SPECIAL_CHARACTERS("A0113", "用户名包含特殊字符"),
    USER_PASSWORD_CHECK_ERROR("A0120", "密码校验失败"),
    USER_PASSWORD_LENGTH_NOT_ENOUGH("A0121", "密码长度不够"),
    USER_PASSWORD_WEAK("A0122", "密码强度不够"),
    USER_CHECK_CODE_INPUT_ERROR("A0130", "校验码输入错误"),


    INTERNAL_SERVER_ERROR("A0500", "系统异常,请联系管理员"),
    PARAMETER_ERROR("A0400", "请求参数错误"),
    ;
    private String code;

    private String message;
}
