package com.worldchurch.webproject.test.service;

import com.worldchurch.webproject.test.dto.User;
import com.worldchurch.webproject.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private User user;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void join(User user) {

        //아이디에 해당하는 사용자가 존재하면 에러
        Optional<User> userOptional = userRepository.getUserByUserId(user.getUserId());

        if (userOptional.isPresent()) {     //이미 사용자 정보가 존재
            user = userOptional.get();
        } else {                            //사용자 정보 존재X
            userRepository.save(user);
        }
    }
}
