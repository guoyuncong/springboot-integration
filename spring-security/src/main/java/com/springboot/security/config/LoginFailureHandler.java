package com.springboot.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        AuthenticationException e) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        resp.setStatus(200);
        Map<String, Object> map = new HashMap<>(16);
        map.put("status", 200);
        ObjectMapper om = new ObjectMapper();
        out.write(om.writeValueAsString(map));
        out.flush();
        out.close();
    }
}
