package com.example.springsecuirtybest.controller;

import com.example.springsecuirtybest.domain.Resource;
import com.example.springsecuirtybest.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@RestController
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
 @GetMapping("/listAll")
    public List<Resource> listAll(){
     return resourceService.listAll();
 }
}
