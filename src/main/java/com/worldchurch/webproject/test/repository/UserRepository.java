package com.worldchurch.webproject.test.repository;

import com.worldchurch.webproject.test.dto.User;

import java.util.Optional;

public interface UserRepository {
    public void save(User user);                            //사용자 정보 저장
    public Optional<User> getUserByUserId(String userId);   //아이디에 맞는 사용자객체 리턴
}
