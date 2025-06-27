package com.numeriquepro.springsecurity.service;

import com.numeriquepro.springsecurity.dto.UserDto;

public interface UserService {
    public UserDto save(UserDto user);
    public String login(UserDto userDto);
}
