package com.example.springsecurity.controller;

import com.example.springsecurity.domain.DataPermissionTest;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.DataPermissionTestService;
import com.example.springsecurity.service.UserService;
import com.example.springsecurity.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@RestController
@RequestMapping("/dataPermission")
public class DataPermissionController {
    @Autowired
    private DataPermissionTestService dataPermissionTestService;
    @RequiresRoles("系统管理员")
    @GetMapping("/list")
    public List<DataPermissionTest> select(DataPermissionTest dataPermissionTest){
        final List<DataPermissionTest> select = dataPermissionTestService.select(dataPermissionTest);
        System.out.println(select);
        return select;
    }
    @GetMapping("fuck")
    public String fuck(){
         return "fuck";
    }
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public void CreateUser( User user){
        userService.createUser(user);
    }
    @RequestMapping("/deleteUser/{userId}")
    public  void deleteUser(@PathVariable String userId){
        userService.deleteUsers(StringUtils.split(userId,","));
    }

}
