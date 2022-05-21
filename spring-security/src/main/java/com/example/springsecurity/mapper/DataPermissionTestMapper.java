package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.DataPermissionTest;
import com.example.springsecurity.domain.DataPermissionTestExample;
import java.util.List;

public interface DataPermissionTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataPermissionTest record);

    int insertSelective(DataPermissionTest record);

    List<DataPermissionTest> selectByExample(DataPermissionTestExample example);

    DataPermissionTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataPermissionTest record);

    int updateByPrimaryKey(DataPermissionTest record);

    List<DataPermissionTest> select(DataPermissionTest dataPermissionTest);
}
