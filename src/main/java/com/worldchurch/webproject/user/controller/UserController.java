package com.worldchurch.webproject.user.controller;

import com.worldchurch.webproject.test.service.HelloWorldService;
import com.worldchurch.webproject.user.dto.UserDto;
import com.worldchurch.webproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String hello(Model model) {
        UserDto userDto = new UserDto();
        userDto.setUserId("lsu");
        userDto.setPassword("");

        boolean result = userService.checkLoginInfo(userDto);

        model.addAttribute("data", result);

        // insert into user_info (ID, BIRTH_DT, EMAIL, NAME, PASSWORD, PHONE_NO, USER_ID) values (1, '', '', '이성욱', '1', '', 'lsu');

        return "test/hello";
    }

    // checkLoginInfo
    @PostMapping("/checkLogin")
    public String checkLogin(Model model, @Valid @NotNull @RequestBody UserDto userDto) {
        boolean result = userService.checkLoginInfo(userDto);

        model.addAttribute("data", result);

        return "test/hello";
    }

    @PostMapping("/registUserInfo")
    public String registUserInfo(Model model, @Valid @NotNull @RequestBody UserDto userDto) {
        userDto = userService.registUserInfo(userDto);

        model.addAttribute("data", userDto);

        return "test/hello";
    }



}
