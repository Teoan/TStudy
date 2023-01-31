package com.teoan.learning.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class UserDTO implements Serializable {
    private String name;
    private int age;
    private String gender;
    private String height;
    private String phoneNumber;
    private String createDate;
    private Boolean admin;

    private String roleName;
}
