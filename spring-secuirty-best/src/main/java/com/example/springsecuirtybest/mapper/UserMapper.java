package com.example.springsecuirtybest.mapper;

import com.example.springsecuirtybest.domain.User;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface UserMapper {
    public User selectByUserName(String username);
}
