package com.security.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Resource Service Config - 资源服务的配置
 *
 *      资源服务的配置，主要包括以下2个方面：
 *          1. 资源服务的安全配置
 *              可以配置 资源 ID、stateless - 资源是否仅允许基于令牌的验证、token 的存储方式等
 *          2. Http 安全配置
 *              Http 安全配置
 */
@Configuration
@EnableResourceServer
public class MyResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/res/**").authenticated();
    }
}
