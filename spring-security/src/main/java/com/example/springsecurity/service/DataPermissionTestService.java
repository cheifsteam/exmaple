package com.example.springsecurity.service;

import com.example.springsecurity.annotation.DataScope;
import com.example.springsecurity.domain.DataPermissionTest;
import com.example.springsecurity.domain.DataPermissionTestExample;
import com.example.springsecurity.mapper.DataPermissionTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
public class DataPermissionTestService {
    @Autowired
    private DataPermissionTestMapper dataPermissionTestMapper;

    private DataPermissionTestExample dataPermissionTestExample;

    @DataScope
    public List<DataPermissionTest> select(DataPermissionTest dataPermissionTest){
        System.out.println("fuck");
        return  dataPermissionTestMapper.select(dataPermissionTest);
    }
}
