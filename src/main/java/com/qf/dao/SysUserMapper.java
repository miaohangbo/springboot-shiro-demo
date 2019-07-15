package com.qf.dao;

import com.qf.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 54110 on 2019-07-13.
 */
@Mapper
public interface SysUserMapper {
    public SysUser findUserByUsername(String username);
}
