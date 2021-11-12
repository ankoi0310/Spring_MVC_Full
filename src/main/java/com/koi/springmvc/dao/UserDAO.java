package com.koi.springmvc.dao;

import com.koi.springmvc.entity.User;

public interface UserDAO {
    User findByUserName(String username);
    void save(User user);
}
