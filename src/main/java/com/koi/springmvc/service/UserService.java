package com.koi.springmvc.service;

import com.koi.springmvc.entity.RegisteredUser;
import com.koi.springmvc.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(RegisteredUser registeredUser);
}
