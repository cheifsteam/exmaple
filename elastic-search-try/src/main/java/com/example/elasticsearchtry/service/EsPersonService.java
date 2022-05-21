package com.example.elasticsearchtry.service;

import com.example.elasticsearchtry.domain.EsPerson;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface EsPersonService  {

        int  importAll();
    Page<EsPerson> search(Integer pageNum,Integer pageSize,String keyword);
    List<EsPerson> searchByMysql(String keyword);

    /**
     * 复杂搜索
     */
//    Page<EsPerson> search( String keyword,Integer pageNum, Integer pageSize, Integer sort);
}
