package com.example.springaoplog.common.controller;

import com.example.springaoplog.common.entity.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */

@Api(value = "Address Interfaces", tags = "Address Interfaces")
@RestController
@RequestMapping("/address")
public class UserController {

    @ApiOperation("hello")
    @RequestMapping("/hello")
    public ResponseResult<String> hello(){
        return  ResponseResult.success("hello");
    }

}
