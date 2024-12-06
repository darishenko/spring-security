package com.example.security.jwt.service;

import com.example.security.jwt.request.SignInRequest;
import com.example.security.jwt.request.SignUpRequest;
import com.example.security.jwt.response.JwtTokenResponse;

public interface AuthenticationService {
    JwtTokenResponse signUp(SignUpRequest signUpRequest);

    JwtTokenResponse signIn(SignInRequest signIpRequest);
}
