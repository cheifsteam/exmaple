package com.example.springsecurity.controller;

//import com.example.spring_security.exception.MyException;
//import com.example.spring_security.sevice.ValidateCodeService;
import com.example.springsecurity.utils.Md5Util;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;

@Validated
@Controller
@RequiredArgsConstructor
public class HomeController {

//    private final ValidateCodeService validateCodeService;
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @PostMapping("/login")
    public String    login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password,
//            @NotBlank(message = "{required}") String verifyCode,
            boolean rememberMe, HttpServletRequest request) {
//        validateCodeService.check(request.getSession().getId(), verifyCode);
        UsernamePasswordToken token = new UsernamePasswordToken(username,
                Md5Util.encrypt(username.toLowerCase(), password), rememberMe);
         Subject subject = SecurityUtils.getSubject();
         subject.login(token);
         System.out.println(1);
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
//    //验证码生成
//    @RequestMapping("images/captcha")
//    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        validateCodeService.create(request, response);
//    }
}
