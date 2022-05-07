package com.example.springsecuirtybest.config;

import com.example.springsecuirtybest.domain.Resource;
import com.example.springsecuirtybest.service.ResourceService;
import com.example.springsecuirtybest.service.impl.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MySecurityConfig extends SecurityConfig {

    @Autowired
    private ResourceService resourceService;

    @Bean
    public DynamicSecurityService dynamicSecurityService(){
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String,ConfigAttribute>map =new HashMap<>();
                List<Resource> resourceList =resourceService.listAll();
                for (Resource resource:resourceList){
                    map.put(resource.getUrl(),new org.springframework.security.access.SecurityConfig(resource.getId()+":"+resource.getName()));
                }
                return map;
            }
        };
    }
}
