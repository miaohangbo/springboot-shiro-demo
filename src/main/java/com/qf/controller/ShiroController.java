package com.qf.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 54110 on 2019-07-13.
 */
@Controller
public class ShiroController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/handlLogin")
    public String handlLogin(@RequestParam("name")String name,@RequestParam("password")String password){

        if(!StringUtils.isEmpty(name)&&!StringUtils.isEmpty(password)){
            
        Subject subject =  SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
            subject.login(token);
        }
        return "main";
    }
    //修改权限
    @RequiresPermissions("user_edit")
    @RequestMapping("/one")
    public String one(){
    return "one_page";
    }
    //添加权限
    @RequiresPermissions("user_forbidden")
    @RequestMapping("/two")
    public String two(){
        return "two_page";
    }
    //没有权限
    @RequestMapping("/unath")
    public String unath(){
        return "unath";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login";
    }
}
