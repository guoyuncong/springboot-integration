package com.springboot.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功处理类
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        Authentication auth) throws IOException, ServletException {
        Object principal = auth.getPrincipal();
        String name = auth.getName();
        System.out.println("------ name -------" + name);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        resp.setStatus(200);
        Map<String, Object> map = new HashMap<>(16);
        map.put("status", 200);
        map.put("msg", principal);
        ObjectMapper om = new ObjectMapper();
        out.write(om.writeValueAsString(map));
        out.flush();
        out.close();
    }
}
