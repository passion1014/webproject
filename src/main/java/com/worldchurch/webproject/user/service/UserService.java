package com.worldchurch.webproject.user.service;

import com.worldchurch.webproject.user.dto.UserDto;

public interface UserService {
    boolean checkLoginInfo (UserDto userInfo);

    UserDto registUserInfo(UserDto userDto);
}
