package com.teoan.learning.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDO {

    private String name;
    private Integer age;
    private String gender;

    private String phoneNumber;


}
