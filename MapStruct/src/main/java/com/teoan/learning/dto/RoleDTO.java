package com.teoan.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
public class RoleDTO {
    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;
}
