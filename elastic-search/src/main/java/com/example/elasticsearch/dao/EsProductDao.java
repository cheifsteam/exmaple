package com.example.elasticsearch.dao;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */


import com.example.elasticsearch.domain.EsProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 * Created by macro on 2018/6/19.
 */
@Mapper
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
