package com.example.springsecuirtybest.service.impl;

import com.example.springsecuirtybest.domain.Resource;
import com.example.springsecuirtybest.mapper.ResourceMapper;
import com.example.springsecuirtybest.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
public class ResourceImpl implements ResourceService {
    @Autowired
    ResourceMapper resourceMapper;
    public List<Resource> listAll(){
     return    resourceMapper.listAll();
    }
}
