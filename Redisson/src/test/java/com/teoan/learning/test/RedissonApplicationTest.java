package com.teoan.learning.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.redisson.api.listener.MessageListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author Teoan
 * @date 2022/11/11 23:28
 * @description
 */
@SpringBootTest
@Slf4j
public class RedissonApplicationTest {

    @Resource
    RedissonClient redissonClient;
    @Resource
    Executor execute;


    @Resource
    ObjectMapper objectMapper;

    @Test
    public void TestRedissonClient() {
        RTopic topic = redissonClient.getTopic("Teoan");
        topic.addListener(String.class,(channel, message)->{
           log.info("鸡汤来咯，看看鸡汤里面是什么[{}]",message);
        });

        // 在其他线程或JVM节点
        execute.execute(()->{
            long clientsReceivedMessage = topic.publish("毒药");
            log.info("clientsReceivedMessage:{}",clientsReceivedMessage);
        });

    }


    @Test
    public void TestRedissonRateLimiter() {
        RRateLimiter rateLimiter = redissonClient.getRateLimiter("myRateLimiter");
        // 初始化
        // 最大流速 = 每1秒钟产生5个令牌
        rateLimiter.trySetRate(RateType.OVERALL, 10, 1, RateIntervalUnit.SECONDS);
        // 10个线程并发
        for (int i = 0; i < 10; i++) {
            execute.execute(()->{
                RRateLimiter limiter = redissonClient.getRateLimiter("myRateLimiter");
                limiter.trySetRate(RateType.OVERALL, 10, 1, RateIntervalUnit.SECONDS);
                // 每次获取5个令牌
                if(limiter.tryAcquire(5)){
                    log.info("get 5 tokens success");
                    // ...
                }else {
                    log.info("get 5 tokens fail");
                }
            });
        }
    }


    @Test
    public void TestRMapCache() throws JsonProcessingException {
        RMapCache<String, Object> map = redissonClient.getMapCache("anyMap");
        // 有效时间 ttl = 10分钟
        map.put("key1", "key1", 10, TimeUnit.MINUTES);
        // 有效时间 ttl = 10分钟, 最长闲置时间 maxIdleTime = 10秒钟
        map.put("key1", "key2", 10, TimeUnit.MINUTES, 10, TimeUnit.SECONDS);

        // 有效时间 = 3 秒钟
        map.putIfAbsent("key2", "key3", 3, TimeUnit.SECONDS);
        // 有效时间 ttl = 40秒钟, 最长闲置时间 maxIdleTime = 10秒钟
        map.putIfAbsent("key2", "key4", 40, TimeUnit.SECONDS, 10, TimeUnit.SECONDS);

        log.info(objectMapper.writeValueAsString(map));
    }




    @Test
    public void TestRMultimap() throws JsonProcessingException {
        RSetMultimap<Object, Object> myMultimap = redissonClient.getSetMultimap("myMultimap");
        myMultimap.put("key1","value1");
        myMultimap.put("key1","value2");
        myMultimap.put("key1","value3");
        myMultimap.put("key2","value1");
        myMultimap.put("key2","value2");

        Set<String> newValue1 = Set.of("newValue1", "newValue2", "newValue3");
        Set<Object> oldValues = myMultimap.replaceValues("key1", newValue1);
        log.info("oldValues:[{}]",objectMapper.writeValueAsString(oldValues));
        Set<Object> removeValues = myMultimap.removeAll("key2");
        log.info("removeValues:[{}]",objectMapper.writeValueAsString(removeValues));
    }

}
