package com.example.springbootjpa.controller;

import com.example.springbootjpa.entity.User;
import com.example.springbootjpa.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public  void addUser(@RequestBody User user)
    {
        userService.addUser(user);
    }

    @GetMapping("/list")
    public List<User> list()
    {
        return userService.list();
    }


}
