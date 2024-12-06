package com.example.security.jwt.request;

import com.example.security.jwt.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private UserRole role;
    private String username;
    private String password;
}
