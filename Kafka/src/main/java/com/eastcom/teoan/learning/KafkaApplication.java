package com.eastcom.teoan.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author zhuangjy
 * @date 2022-06-13 15:24
 */
@SpringBootApplication
@EnableKafka
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class,args);
    }
}
