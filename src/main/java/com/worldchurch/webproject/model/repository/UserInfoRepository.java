package com.worldchurch.webproject.model.repository;

import com.worldchurch.webproject.model.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUserId(String userId);


}
