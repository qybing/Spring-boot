package com.jovan;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SpringBootUserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUserConsumerApplication.class, args);
    }
}
