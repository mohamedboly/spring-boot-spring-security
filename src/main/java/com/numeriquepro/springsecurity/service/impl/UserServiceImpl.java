package com.numeriquepro.springsecurity.service.impl;

import com.numeriquepro.springsecurity.dao.UserRepository;
import com.numeriquepro.springsecurity.dto.UserDto;
import com.numeriquepro.springsecurity.entity.User;
import com.numeriquepro.springsecurity.mapper.UserMapper;
import com.numeriquepro.springsecurity.service.JwtService;
import com.numeriquepro.springsecurity.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public UserDto save(UserDto user) {

      User userEntity = UserMapper.toEntity(user);
      userEntity.setId(null);
      userEntity.setPassword(bCryptPasswordEncoder
                .encode(user.getPassword()));

        return UserMapper.toDto(userRepository.save(userEntity));
    }

    public String login(UserDto userDto) {
        Authentication authenticate
                = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(), userDto.getPassword()
                )
        );

        //var u = userRepository.findByUserName(user.getUserName());
        if(authenticate.isAuthenticated())
            return jwtService.generateToken(UserMapper.toEntity(userDto));
        return "failure";
    }
}
