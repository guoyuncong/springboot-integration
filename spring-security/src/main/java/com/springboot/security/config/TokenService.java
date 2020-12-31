package com.springboot.security.config;

import cn.hutool.core.util.StrUtil;
import com.springboot.security.model.entity.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import com.springboot.security.base.constants.Constants;

/**
 * @author: yagena
 * @date: 2020-11-24
 */
@Component
public class TokenService {

    /**
     * 令牌自定义标识
     */
    @Value("${token.header}")
    private String header;

    /**
     * 令牌秘钥
     */
    @Value("${token.secret}")
    private String secret;

    /**
     * 令牌有效期（默认30分钟）
     */
    @Value("${token.expireTime}")
    private int expireTime;

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public SysUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StrUtil.isNotEmpty(token)) {
            // 解析 JWT 的 Token
            Claims claims = parseToken(token);
            // 从 Redis 缓存中，获得对应的 LoginUser
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
//            String userKey = getTokenKey(uuid);
//            return redisCache.getCacheObject(userKey);
        }
        return null;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 获取请求token
     *
     * @param request
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StrUtil.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

}
