package com.springboot.security.model.dto;

import com.springboot.security.enums.ResultCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResultDTO<T> {

    /**
     * 返回码
     */
    private final String code;

    /**
     * 描述
     */
    private final String message;

    /**
     * 数据
     */
    private final T detail;

    public static <T> ResultDTO<T> ofSuccess(T detail) {
        return of(ResultCode.SUCCESS, detail);
    }

    public static <T> ResultDTO<T> ofSuccess() {
        return of(ResultCode.SUCCESS);
    }

    public static <T> ResultDTO<T> of(ResultCode resultCode, T detail) {
        return new ResultDTO<>(resultCode.getCode(), resultCode.getMessage(), detail);
    }

    public static <T> ResultDTO<T> of(ResultCode resultCode) {
        return new ResultDTO<>(resultCode.getCode(), resultCode.getMessage(), null);
    }

    public boolean isSuccess() {
        return ResultCode.SUCCESS.name().equals(code);
    }
}
