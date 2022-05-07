package com.example.elasticsearchtry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.elasticsearchtry.mapper")
public class ElasticSearchTryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchTryApplication.class, args);
    }

}
