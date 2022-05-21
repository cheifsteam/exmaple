package com.example.spring_security.controller;

import com.example.spring_security.exception.MyException;
import com.example.spring_security.properties.ValidateCodeProperties;
import com.example.spring_security.sevice.ValidateCodeService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.validation.constraints.NotBlank;

@Validated
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ValidateCodeService validateCodeService;
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @PostMapping("login")
    public String    login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password,
            @NotBlank(message = "{required}") String verifyCode,
            boolean rememberMe, HttpServletRequest request) throws MyException{
        validateCodeService.check(request.getSession().getId(), verifyCode);
        UsernamePasswordToken token = new UsernamePasswordToken(username,
                 password, rememberMe);
         Subject subject = SecurityUtils.getSubject();
         subject.login(token);
         return "/index";
    }
    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
    //验证码生成
    @RequestMapping("images/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException{
        validateCodeService.create(request, response);
    }
}