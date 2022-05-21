package com.example.springsecuirtybest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@MapperScan("com.example.springsecuirtybest.mapper")
public class SpringSecuirtyBestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecuirtyBestApplication.class, args);
    }

}
