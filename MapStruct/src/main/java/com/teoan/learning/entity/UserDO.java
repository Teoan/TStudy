package com.teoan.learning.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDO {
    private String name;
    private Integer age;
    private Integer height;
    private String roleName;
    private String gender;
    private String phoneNumber;
    private Date createDate;
}
