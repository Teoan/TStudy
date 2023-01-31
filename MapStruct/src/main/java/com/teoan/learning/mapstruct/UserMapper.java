package com.teoan.learning.mapstruct;

import com.teoan.learning.dto.UserDTO;
import com.teoan.learning.entity.UserDO;
import org.mapstruct.*;
import org.springframework.util.ObjectUtils;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,builder = @Builder(disableBuilder = true))
public abstract class UserMapper {

    @BeforeMapping
    protected void setDefHeight(UserDO userDO){
        if(ObjectUtils.isEmpty(userDO.getHeight())){
            userDO.setHeight(170);
        }
    }


    @AfterMapping
    protected void setAdmin(@MappingTarget UserDTO userDTO){
        userDTO.setAdmin(userDTO.getRoleName().equals("admin"));
    }


    public abstract UserDTO toTarget(UserDO userDO);

}
