package com.teoan.learning.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String name;
    private Integer age;
    private String gender;

    private String phoneNumber;


}
