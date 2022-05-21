package com.example.spring_security.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Controller
public class UserInfoController {
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")
    public String getUserInfo(){
        return "userInfo";
    }
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String addUserInfo(){
        return "userInfoAdd";
    }
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    public String DelUserInfo(){
        return "userInfoDel";
    }
}
