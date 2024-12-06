package com.example.security.jwt.controller;

import com.example.security.jwt.request.SignInRequest;
import com.example.security.jwt.request.SignUpRequest;
import com.example.security.jwt.response.JwtTokenResponse;
import com.example.security.jwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public JwtTokenResponse signUp(@RequestBody SignUpRequest signUpRequest) {
        return authenticationService.signUp(signUpRequest);
    }

    @PostMapping("/login")
    public JwtTokenResponse signIn(@RequestBody SignInRequest signInRequest) {
        return authenticationService.signIn(signInRequest);
    }

}
