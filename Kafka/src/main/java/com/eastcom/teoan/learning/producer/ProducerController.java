package com.eastcom.teoan.learning.producer;

import com.eastcom.teoan.learning.contant.KafkaContant;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhuangjy
 * @description
 * @date 2022-06-13 16:01
 */
@RestController
public class ProducerController {

    @Resource
    KafkaTemplate kafkaTemplate;

    @PostMapping("/sendMessage")
    public void sandMessage(){
        kafkaTemplate.send(KafkaContant.TOPIC_NAME,"zhuangjy-test","test");
    }
}
