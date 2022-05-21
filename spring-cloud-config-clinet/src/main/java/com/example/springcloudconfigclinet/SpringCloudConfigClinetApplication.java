package com.example.springcloudconfigclinet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigClinetApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClinetApplication.class, args);
    }

}
