package com.teoan.learning.mapstruct;

import com.teoan.learning.dto.UserDTO;
import com.teoan.learning.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapStruct extends BaseMapStruct<UserDO, UserDTO> {

}
