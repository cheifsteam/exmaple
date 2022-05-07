package com.example.springsecurity.controller;

import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.UserService;
import com.example.springsecurity.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
