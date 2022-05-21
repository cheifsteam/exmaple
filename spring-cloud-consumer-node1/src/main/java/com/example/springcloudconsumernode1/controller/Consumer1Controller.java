package com.example.springcloudconsumernode1.controller;

import com.example.springcloudconsumernode1.remote.HelloRemote;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@RestController
public class Consumer1Controller {

    @Qualifier("helloRemoteHystrix")
    @Autowired
    HelloRemote HelloRemote;
    @HystrixCommand
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return HelloRemote.hello(name);
    }

}