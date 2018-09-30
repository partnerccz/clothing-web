package com.clothing.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.clothing.web.dao.")
public class ClothingWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothingWebApplication.class, args);
    }
}
