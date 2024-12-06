package com.example.security.jwt.service.impl;

import com.example.security.jwt.model.User;
import com.example.security.jwt.repository.UserRepository;
import com.example.security.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(User user) {
        user.setPassword(encodePassword(user.getPassword()));

        userRepository.save(user);
        user.eraseCredentials();

        return user;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.findUsersByUsername(username).isPresent();
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
