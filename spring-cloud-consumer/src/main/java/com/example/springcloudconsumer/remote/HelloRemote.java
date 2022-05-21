package com.example.springcloudconsumer.remote;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@FeignClient(name= "spring-cloud-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {


    @RequestMapping(value = "/hello")

    public String hello(@RequestParam(value = "name") String name);


}