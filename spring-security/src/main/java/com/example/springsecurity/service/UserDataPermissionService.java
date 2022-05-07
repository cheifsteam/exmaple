package com.example.springsecurity.service;

import com.example.springsecurity.domain.UserDataPermissionExample;
import com.example.springsecurity.domain.UserDataPermissionKey;
import com.example.springsecurity.mapper.UserDataPermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
public class UserDataPermissionService {
    @Resource
    private UserDataPermissionMapper userDataPermissionMapper;

    private UserDataPermissionExample userDataPermissionExample;
    public  int saveBatch(UserDataPermissionKey userDataPermissionKey ){
         return  userDataPermissionMapper.insert(userDataPermissionKey);
    }
    public List<UserDataPermissionKey> findByUserId(Long userId){
        userDataPermissionExample=new UserDataPermissionExample();
        userDataPermissionExample.createCriteria().andUserIdEqualTo(userId);
        List<UserDataPermissionKey> userDataPermissionKeys = userDataPermissionMapper.selectByExample(userDataPermissionExample);
        return  userDataPermissionKeys;
    }


}
