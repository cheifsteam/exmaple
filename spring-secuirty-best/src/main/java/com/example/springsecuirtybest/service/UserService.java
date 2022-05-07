package com.example.springsecuirtybest.service;

import com.example.springsecuirtybest.domain.User;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface UserService {
    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 用户对象信息
     */
    public User selectByUserName(String username);

}
