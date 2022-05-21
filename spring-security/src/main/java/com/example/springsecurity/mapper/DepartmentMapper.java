package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.Department;
import com.example.springsecurity.domain.DepartmentExample;
import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long deptId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Long deptId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}