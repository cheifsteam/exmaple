package com.example.springsecuirtybest.service;

import com.example.springsecuirtybest.domain.Resource;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */

public interface ResourceService {
    /**
     * 获取所有资源
     * @return
     */
    List<Resource> listAll();

}
