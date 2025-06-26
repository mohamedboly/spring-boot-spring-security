package com.numeriquepro.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                request -> request
                        .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
              ;

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1
                = User.withUsername("user1")
                .password("{noop}password1")
                .roles("USER")
                .build();

        UserDetails user2
                = User.withUsername("user2")
                .password("{noop}password2")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}
