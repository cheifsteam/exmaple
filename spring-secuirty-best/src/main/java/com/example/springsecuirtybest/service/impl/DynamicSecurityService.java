package com.example.springsecuirtybest.service.impl;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface DynamicSecurityService {
    Map<String, ConfigAttribute> loadDataSource();
}
