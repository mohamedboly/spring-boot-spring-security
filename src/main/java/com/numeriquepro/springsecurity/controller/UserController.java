package com.numeriquepro.springsecurity.controller;

import com.numeriquepro.springsecurity.dto.UserDto;
import com.numeriquepro.springsecurity.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDto save(@RequestBody UserDto userDto) {

        return userService.save(userDto);
    }
    @PostMapping("/login")
    private String login(@RequestBody UserDto userDto) {
       return  userService.login(userDto);
    }
}
