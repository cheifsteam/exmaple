package com.example.springsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springsecurity.domain.User;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface UserServiceImpl extends IService<User> {
    /**
     * 新增用户
     *
     * @param user user
     */
    void createUser(User user);

    /**
     * 删除用户
     *
     * @param userIds 用户 id数组
     */
    void deleteUsers(String[] userIds);

    /**
     * 修改用户
     *
     * @param user user
     */
    void updateUser(User user);
    /**
     * 注册用户
     *
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);

}
