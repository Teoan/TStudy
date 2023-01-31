package com.teoan.learning.mapstruct;

import com.teoan.learning.dto.RoleDTO;
import com.teoan.learning.entity.RoleDO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapStruct extends BaseMapStruct<RoleDO, RoleDTO>{

}
