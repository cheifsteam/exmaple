package com.example.springcloudproducer1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Slf4j
@RestController
public class HelloController {


    @RequestMapping("/hello")

    public String index(@RequestParam String name) {
        log.info("request two name is "+name);
        try{
            Thread.sleep(1000000);
        }catch ( Exception e){
            log.error(" hello two error",e);
        }
        return "hello "+name+"，this is producer 2  send first messge";
    }
    @RequestMapping("/foo")
    public String foo(String foo) {
        return "hello "+foo+"!!";
    }
}