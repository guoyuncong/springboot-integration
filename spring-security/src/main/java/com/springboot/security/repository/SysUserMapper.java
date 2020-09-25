package com.springboot.security.repository;

import com.springboot.security.model.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author: gyc
 * @date: 2020-08-17 15:20
 * @description:
 */
public interface SysUserMapper {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    SysUser selectUserByUserName(@Param("userName") String userName);
}
