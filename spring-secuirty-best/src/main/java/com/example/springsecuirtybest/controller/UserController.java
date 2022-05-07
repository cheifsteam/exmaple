package com.example.springsecuirtybest.controller;

import com.example.springsecuirtybest.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@RestController
public class UserController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password){
        final String login = loginService.login(username, password);
        return login;
    }

    @GetMapping("/index")
    public String index(){
        return "hello";
    }
}
