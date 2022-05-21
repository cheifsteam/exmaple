package com.example.spring_security.sevice.impl;

import com.example.spring_security.dao.UserInfoDao;
import com.example.spring_security.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserInfoServiceImpl userInfoService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userInfoService.findByUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String encode = passwordEncoder.encode("123456");
        if(user == null){
            log.info("登录用户[{}]没注册!",username);
            throw new UsernameNotFoundException("登录用户["+username + "]没注册!");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), encode, getAuthority());

    }
    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return Arrays.asList(Collections.emptyList());
    }

}
