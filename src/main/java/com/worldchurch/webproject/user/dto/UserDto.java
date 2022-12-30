package com.worldchurch.webproject.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private String phoneNo;
    private String birthDt;

}
