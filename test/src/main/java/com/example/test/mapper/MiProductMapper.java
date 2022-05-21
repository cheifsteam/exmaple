package com.example.test.mapper;

import com.example.test.domain.MiProduct;

public interface MiProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MiProduct record);

    int insertSelective(MiProduct record);

    MiProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MiProduct record);

    int updateByPrimaryKey(MiProduct record);

    Long queryPrice(String type);
}
