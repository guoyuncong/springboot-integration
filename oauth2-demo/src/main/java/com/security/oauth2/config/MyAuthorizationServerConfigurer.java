package com.security.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @author: yagena
 * @date: 2020-11-24
 */

/**
 * Authorization Service Config - 认证服务配置
 *
 * 认证服务的配置，主要包括以下3个方面
 *      1. 定义 token endpoint 的安全约束
 *          主要配置：是否允许客户端以 Form 表单的形式的登录、定义密码的加密方式等
 *      2. 定义客户端详细的信息
 *          客户端的信息包括了：客户端的信息存储方式（内存 or 数据库）以及客户端的认证需要的信息，
 *          包括 client_id、client_secret、grant_type、scope
 *      3. 定义授权和 token endpoint 以及令牌服务。
 *          可以配置授权的 endpoint、token 的存储方式等
 */
@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    /**
     * 配置安全约束相关配置
     * @param security 定义令牌终结点上的安全约束
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 支持client_id、client_secret以form表单的形式登录,参考可见：微信获取access token
        security.allowFormAuthenticationForClients();
    }

    /**
     * 配置客户端详细信息
     * @param clients 定义客户端详细信息服务的配置程序。可以初始化客户端详细信息，也可以只引用现有存储。
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // client_id
                .withClient("gold")
                // 授权方式
                .authorizedGrantTypes("client_credentials")
                // 授权范围
                .scopes("write")
                // client_secret
                .secret("{noop}123456");

    }

    /**
     *
     * @param endpoints 定义授权和令牌端点以及令牌服务。
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }
}
