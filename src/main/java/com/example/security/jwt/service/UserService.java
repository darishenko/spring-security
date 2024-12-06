package com.example.security.jwt.service;

import com.example.security.jwt.model.User;

public interface UserService {
    User create(User user);

    boolean existsByUsername(String username);
}
