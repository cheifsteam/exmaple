package com.example.schedulingtasks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

public class SchedulingtasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulingtasksApplication.class, args);
    }

}
