package com.worldchurch.webproject.test.controller;

import com.worldchurch.webproject.test.service.HelloWorldService;
import com.worldchurch.webproject.test.service.HelloWorldServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    HelloWorldService helloWorldService;

    @GetMapping("/test/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloWorldService.getGreeting(name);
    }
}
