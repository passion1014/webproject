package com.worldchurch.webproject.user.service;

import com.worldchurch.webproject.model.entity.UserInfo;
import com.worldchurch.webproject.model.repository.UserInfoRepository;
import com.worldchurch.webproject.user.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserInfoRepository userInfoRepository;

    @Override
    public boolean checkLoginInfo(UserDto userDto) {
        UserInfo userInfo = userInfoRepository.findByUserId(userDto.getUserId());
        return userInfo != null && !"".equals(userInfo.getId());
    }

    //
    @Override
    public UserDto registUserInfo(UserDto userDto) {
        UserInfo userInfo = new UserInfo();

        userInfo.setUserId(userDto.getUserId());
        userInfo.setEmail(userDto.getEmail());
        userInfo.setBirthDt(userDto.getBirthDt());
        userInfo.setName(userDto.getName());
        userInfo.setPassword(userDto.getPassword());
        userInfo.setPhoneNo(userDto.getPhoneNo());

        userInfo = userInfoRepository.save(userInfo);

        userDto.setId(userInfo.getId());
        return userDto;
    }


}
