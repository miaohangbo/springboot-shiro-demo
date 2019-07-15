package com.qf.service.impl;

import com.qf.dao.SysUserMapper;
import com.qf.domain.SysUser;
import com.qf.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 54110 on 2019-07-13.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findUserByUsername(String username) {
        return sysUserMapper.findUserByUsername(username);
    }
}
