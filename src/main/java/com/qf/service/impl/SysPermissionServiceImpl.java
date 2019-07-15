package com.qf.service.impl;

import com.qf.dao.SysPermissionMapper;
import com.qf.domain.SysPermission;
import com.qf.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 54110 on 2019-07-13.
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> findPermissionByUserLoginName(String name) {

        return sysPermissionMapper.findPermissionByUserLoginName(name);
    }
}
