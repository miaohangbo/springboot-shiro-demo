package com.qf.service;

import com.qf.domain.SysPermission;

import java.util.List;

/**
 * Created by 54110 on 2019-07-13.
 */
public interface SysPermissionService {
    List<SysPermission> findPermissionByUserLoginName(String name);

}
