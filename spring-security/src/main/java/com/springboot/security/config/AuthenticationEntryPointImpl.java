package com.springboot.security.config;

import com.springboot.security.base.enums.ResultCode;
import com.springboot.security.base.exception.BizException;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: gyc
 * @date: 2020-08-13 17:21
 * @description: 认证失败处理类
 */
@Configuration
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        throw BizException.of(ResultCode.USER_UNAUTHORIZED_ACCESS);
    }
}
