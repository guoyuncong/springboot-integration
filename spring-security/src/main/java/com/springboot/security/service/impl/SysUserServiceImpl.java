package com.springboot.security.service.impl;

import com.springboot.security.model.entity.SysUser;
import com.springboot.security.repository.SysUserMapper;
import com.springboot.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: gyc
 * @date: 2020-08-17 15:17
 * @description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByUserName(String userName) {
        return sysUserMapper.selectUserByUserName(userName);
    }
}
