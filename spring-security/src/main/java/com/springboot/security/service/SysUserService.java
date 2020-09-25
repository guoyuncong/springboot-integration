package com.springboot.security.service;

import com.springboot.security.model.entity.SysUser;

/**
 * @author: gyc
 * @date: 2020-08-17 15:17
 * @description:
 */
public interface SysUserService {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String userName);
}
