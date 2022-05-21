package com.example.springaoplog.common.controller;

import com.example.springaoplog.common.annotation.RateLimit;
import com.example.springaoplog.common.entity.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Api(value = "limit Interface" ,tags = "limit Interface")
@Slf4j
@RestController
public class RateLimitTestController {

    @RateLimit
    @ApiOperation("test limit")
    @GetMapping("/limit")
    public ResponseResult<String> limit()
    {
        log.info("limit");
        return  ResponseResult.success();
    }
    @RateLimit(limit = 5)
    @GetMapping("/limit1")
    public ResponseResult<String> limit1() {
        log.info("limit1");
        return ResponseResult.success();
    }
}
