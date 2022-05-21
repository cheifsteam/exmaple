package com.example.spring_security.sevice;


import com.example.spring_security.domain.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}