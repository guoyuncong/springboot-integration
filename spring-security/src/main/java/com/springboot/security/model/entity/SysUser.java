package com.springboot.security.model.entity;

import lombok.Data;

/**
 * @author: gyc
 * @date: 2020-08-14 15:22
 * @description:
 */
@Data
public class SysUser {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;
}
