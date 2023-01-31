package com.teoan.learning;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teoan.learning.entity.RoleDO;
import com.teoan.learning.dto.UserDTO;
import com.teoan.learning.entity.UserDO;
import com.teoan.learning.mapstruct.UserMapStruct;
import com.teoan.learning.mapstruct.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@Slf4j
public class MapStructApplicationTest {

    @Resource
    UserMapStruct userMapStruct;

    @Resource
    UserMapper userMapper;

    @Resource
    ObjectMapper objectMapper;


    @Test
    public void testMapStruct() throws JsonProcessingException {
        UserDO userDO = UserDO.builder().name("test").age(18).phoneNumber("12345678").gender("man")
                .createDate(new Date()).roleName("admin").build();
        UserDTO userDTO = userMapper.toTarget(userDO);
        log.info(objectMapper.writeValueAsString(userDTO));
    }

    @Test
    public void testMapToBean() throws JsonProcessingException {
        Map userMap = Map.of("userName","testName",
                "height","2","roleName","admin");

        UserDO userDO = userMapStruct.toUserDO(userMap);

        log.info(objectMapper.writeValueAsString(userDO));

    }




}
