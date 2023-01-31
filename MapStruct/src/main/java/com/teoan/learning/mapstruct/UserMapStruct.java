package com.teoan.learning.mapstruct;

import com.teoan.learning.entity.RoleDO;
import com.teoan.learning.dto.UserDTO;
import com.teoan.learning.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapStruct extends BaseMapStruct<UserDO, UserDTO> {


    @Override
    @Mappings(value = {
            @Mapping(source = "createDate",dateFormat = "yyyy-MM-dd",target = "createDate"),
    @Mapping(source = "height",numberFormat = "#cm",target = "height")})
    UserDTO toTarget(UserDO userDO);


    @Mapping(source = "userName",target = "name")
    UserDO toUserDO(Map<String, String> map);
}
