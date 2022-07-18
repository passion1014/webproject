package com.worldchurch.webproject.test.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String getGreeting(String name) {
        return "hello word! " + name + "님 안녕하세요.";
    }
}



