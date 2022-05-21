package com.example.springtreeselect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springtreeselect.mapper")
public class SpringTreeselectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTreeselectApplication.class, args);
    }

}
