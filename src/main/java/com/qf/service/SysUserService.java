package com.qf.service;

import com.qf.domain.SysUser;

/**
 * Created by 54110 on 2019-07-13.
 */
public interface SysUserService {

    public SysUser findUserByUsername(String username);

}
