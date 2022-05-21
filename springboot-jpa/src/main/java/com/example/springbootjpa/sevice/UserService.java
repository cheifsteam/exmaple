package com.example.springbootjpa.sevice;

import com.example.springbootjpa.entity.User;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface UserService {

    void addUser(User user);

    List<User> list();
}
