package com.example.springtreeselect.controller;

import com.example.springtreeselect.domain.AjaxResult;
import com.example.springtreeselect.domain.Dept;
import com.example.springtreeselect.service.IDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class DeptController {
    @Autowired
    private IDeptService deptService;
    private static final Logger log= LoggerFactory.getLogger(DeptController.class);
    @GetMapping("/treeselect")
    public AjaxResult treeselect(Dept dept)
    {
        List<Dept> depts = deptService.selectDeptList(dept);
        System.out.println("sd"+depts);
        return AjaxResult.success(deptService.buildDeptTreeSelect(depts));
    }
}
