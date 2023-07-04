package com.hui.springbootproj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.hui.springbootproj.mapper")
public class SpringBootProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjApplication.class, args);
    }

}
