package com.example.test.mapper;

import com.example.test.domain.TblUser;

public interface TblUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(TblUser record);

    int insertSelective(TblUser record);

    TblUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TblUser record);

    int updateByPrimaryKey(TblUser record);
}