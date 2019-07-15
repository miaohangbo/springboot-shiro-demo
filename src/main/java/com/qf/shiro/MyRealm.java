package com.qf.shiro;

import com.qf.domain.SysPermission;
import com.qf.domain.SysUser;
import com.qf.service.SysPermissionService;
import com.qf.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 54110 on 2019-07-13.
 */
@Component("myRealm")
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username =(String) principalCollection.getPrimaryPrincipal();
        List<SysPermission> permissionByUserLoginName = sysPermissionService.findPermissionByUserLoginName(username);
        if (permissionByUserLoginName!=null){
            Collection<String > objects = new HashSet<String>();
            for (SysPermission per:permissionByUserLoginName){
                objects.add(per.getPermName());
            }
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addStringPermissions(objects);
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        SysUser userByUsername = sysUserService.findUserByUsername(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, userByUsername.getPassword(), getName());
        return simpleAuthenticationInfo;
    }
}
