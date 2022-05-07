package com.example.elasticsearchtry.mapper;

import com.example.elasticsearchtry.domain.EsPerson;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface EsPersonMapper {
    List<EsPerson> selectEsPersonList(Long personId);
    List<EsPerson> searchByMysql(String keyword);
}
