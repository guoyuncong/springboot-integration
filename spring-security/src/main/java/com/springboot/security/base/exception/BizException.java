package com.springboot.security.base.exception;

import com.springboot.security.base.enums.ResultCode;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {

    private ResultCode code;

    private Object detail;

    private BizException(ResultCode code) {
        super(code.getMessage());
        this.code = code;
    }

    private BizException(ResultCode code, Object detail) {
        super(code.getMessage());
        this.code = code;
        this.detail = detail;
    }

    public static BizException of(ResultCode code) {
        return new BizException(code);
    }

    public static BizException of(ResultCode code, Object detail) {
        return new BizException(code, detail);
    }
}
