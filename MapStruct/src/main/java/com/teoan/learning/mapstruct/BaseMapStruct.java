package com.teoan.learning.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

public interface BaseMapStruct<SOURCE,TARGET>{


    TARGET toTarget(SOURCE source);


    SOURCE toSource(TARGET target);


    List<SOURCE> toSourceList(List<TARGET> targetList);


    List<TARGET> toTargetList(List<SOURCE> sourceList);


}
