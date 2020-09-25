package com.springboot.security.config;

import com.springboot.security.model.entity.SysUser;
import com.springboot.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author: gyc
 * @date: 2020-08-14 14:38
 * @description:
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询指定用户名对应的 SysUser
        SysUser user = sysUserService.selectUserByUserName(username);
        return null;
    }
}
