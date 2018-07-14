package com.tiye.IntelligentClass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.tiye.IntelligentClass.dao")
public class IntelligentClassApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntelligentClassApplication.class, args);
    }
}
