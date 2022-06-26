package com.eastcom.teoan.learning.config;

import com.eastcom.teoan.learning.contant.KafkaContant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author zhuangjy
 * @description
 * @date 2022-06-13 15:31
 */
@Configuration
@EnableKafka
public class KafkaConfig {

    /**
     * 创建topic
     * @return
     */
    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name(KafkaContant.TOPIC_NAME).partitions(3).replicas(3).compact().build();
    }
}

