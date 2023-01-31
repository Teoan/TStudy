package com.teoan.learning.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class RoleDO {

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;
}
