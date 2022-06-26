package com.eastcom.teoan.learning.consumer;

import com.eastcom.teoan.learning.contant.KafkaContant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @author Teoan
 * @date 2022/6/26 16:44
 * @description
 */
@Slf4j
@Component
public class ConsumerListener {

    @KafkaListener(topics = KafkaContant.TOPIC_NAME)
    public void processMessage(String content){
        log.info("接收到一条消息【{}】",content);
    }
}
