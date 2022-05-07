package com.example.springsecurity.service;

import com.example.springsecurity.domain.Role;
import com.example.springsecurity.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    public List<Role>  findUserRole(String name){
        return roleMapper.findUserRole(name)  ;

    }

}
