package com.teoan.learning;

import com.teoan.learning.entity.UserDO;
import com.teoan.learning.mapstruct.UserMapStruct;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@Slf4j
public class MapStructApplicationTest {

    @Resource
    UserMapStruct userMapStruct;


    @Test
    public void testMapStruct(){
        UserDO userDO = UserDO.builder().name("test").age(18).phoneNumber("12345678").gender("man").build();
        log.info(userMapStruct.toTarget(userDO).toString());
    }

}
