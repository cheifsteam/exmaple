package com.example.springsecurity.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecurity.domain.Role;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.domain.UserExample;
import com.example.springsecurity.domain.UserRole;
import com.example.springsecurity.mapper.RoleMapper;
import com.example.springsecurity.mapper.UserMapper;
import com.example.springsecurity.mapper.UserRoleMapper;
import com.example.springsecurity.service.impl.IUserRoleServiceImpl;
import com.example.springsecurity.service.impl.UserServiceImpl;
import com.example.springsecurity.utils.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
public class UserService extends ServiceImpl<UserMapper,User>implements UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleService;

    @Autowired
    private IUserRoleServiceImpl userRoleService;

    private UserExample userExample;
    public User findUserByName(String name){
        userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);
        return  users.get(0);
    }

    public void doGetUserAuthorizationInfo(User user) {
        // 获取用户角色集
        List<Role> roleList = roleService.findUserRole(user.getUsername());
        Set<String> roleSet = roleList.stream().map(Role::getRoleName).collect(Collectors.toSet());
        user.setRoles(roleSet);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(User user) {
        user.setCreateTime(new Date());
        user.setStatus("1");
        user.setIsTab("1");
        user.setDeptId(0L);
        user.setSsex("1");
        user.setModifyTime(new Date());
        user.setAvatar("dad");
        user.setTheme("balck");
        user.setMobile("1232489084914");
        user.setDescription("safaf");
        user.setLastLoginTime(new Date());
        user.setEmail("321341414@qoo");


        user.setPassword(Md5Util.encrypt(user.getUsername(),"1234qwer"));
        save(user);
        System.out.println("fuck"+user.getUserId());
        String[] roles =user.getRoleId().split(",");
        setUserRoles(user,roles);

    }
    private  void setUserRoles(User user,String[] roles){
        List<UserRole>userRoles=new ArrayList<>();
        Arrays.stream(roles).forEach(roleId ->{
            UserRole userRole =new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(Long.valueOf(roleId));
            userRoles.add(userRole);
        });
        userRoleService.saveBatch(userRoles);


    }
    @Override
    public void deleteUsers(String[] userIds) {
        List<String> list =Arrays.asList(userIds);
        removeByIds(list);
        userRoleService.deleteUserRolesByUserId(list);

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(User user) {
        // 更新用户
        user.setPassword(null);
        user.setUsername(null);
        user.setModifyTime(new Date());
        updateById(user);

        String[] userId = {String.valueOf(user.getUserId())};
        userRoleService.deleteUserRolesByUserId(Arrays.asList(userId));
        String[] roles = StringUtils.splitByWholeSeparatorPreserveAllTokens(user.getRoleId(), ",");
        setUserRoles(user, roles);
    }

    @Override
    public void register(String username, String password) {

    }
}
