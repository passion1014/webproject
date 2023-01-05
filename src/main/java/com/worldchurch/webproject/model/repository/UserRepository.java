package com.worldchurch.webproject.model.repository;

import com.worldchurch.webproject.model.entity.UserInfo;
import com.worldchurch.webproject.user.dto.UserDto;

import java.util.Optional;

public interface UserRepository {
    public UserInfo save(UserInfo userInfo);                            //사용자 정보 저장
    public UserInfo findByUserId(String userId);   //아이디에 맞는 사용자객체 리턴
}
