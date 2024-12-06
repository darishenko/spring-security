package com.example.security.jwt.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtTokenResponse {
    private String jwtToken;
}
