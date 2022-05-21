package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.UserDataPermissionExample;
import com.example.springsecurity.domain.UserDataPermissionKey;
import java.util.List;

public interface UserDataPermissionMapper {
    int deleteByPrimaryKey(UserDataPermissionKey key);

    int insert(UserDataPermissionKey record);

    int insertSelective(UserDataPermissionKey record);

    List<UserDataPermissionKey> selectByExample(UserDataPermissionExample example);
}