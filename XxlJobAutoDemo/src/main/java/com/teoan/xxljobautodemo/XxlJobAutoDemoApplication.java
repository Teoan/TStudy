package com.teoan.xxljobautodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class XxlJobAutoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlJobAutoDemoApplication.class, args);
    }

}
