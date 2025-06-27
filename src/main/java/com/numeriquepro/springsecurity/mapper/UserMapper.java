package com.numeriquepro.springsecurity.mapper;

import com.numeriquepro.springsecurity.entity.User;
import com.numeriquepro.springsecurity.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(
                user.getId(),
            user.getUsername(),
            user.getPassword()
        );
    }

    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        return new User(
            userDto.getId(),
            userDto.getUsername(),
            userDto.getPassword()
        );
    }
}
