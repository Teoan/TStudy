package com.teoan.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Teoan
 * @date 2022/11/10 22:21
 * @description
 */
@SpringBootApplication
@EnableAsync
public class RedissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedissonApplication.class,args);
    }
}
