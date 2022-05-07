package com.example.springsecuirtybest.service.impl;

import com.example.springsecuirtybest.annotation.CacheException;
import com.example.springsecuirtybest.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
public class LoginService {
    @Resource
    private AuthenticationManager authenticationManager;
    @Autowired
    private  TokenService tokenService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @CacheException
    public String login(String username, String password) {
         User userDetails = (User) userDetailsService.loadUserByUsername(username);

        // 用户验证
        Authentication authentication = null;
        try
        {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                throw new RuntimeException("用户密码错误");
            }else {
                throw new RuntimeException(e.getMessage());
            }

        }
        User loginUser= (User) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }

}
