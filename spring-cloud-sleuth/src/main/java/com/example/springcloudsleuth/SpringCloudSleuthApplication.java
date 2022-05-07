package com.example.springcloudsleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudSleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSleuthApplication.class, args);
    }

}
