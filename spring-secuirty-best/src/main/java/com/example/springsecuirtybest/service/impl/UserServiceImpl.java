package com.example.springsecuirtybest.service.impl;

import com.example.springsecuirtybest.domain.User;
import com.example.springsecuirtybest.mapper.UserMapper;
import com.example.springsecuirtybest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByUserName(String username) {
      return   userMapper.selectByUserName(username);
    }
}
