package com.qf.dao;

import com.qf.domain.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 54110 on 2019-07-13.
 */
@Mapper
public interface SysPermissionMapper {
    List<SysPermission> findPermissionByUserLoginName(@Param("name") String name);
}
