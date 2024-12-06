package com.example.security.jwt.service.impl;

import com.example.security.jwt.exception.UsernameDuplicateException;
import com.example.security.jwt.model.User;
import com.example.security.jwt.request.SignInRequest;
import com.example.security.jwt.request.SignUpRequest;
import com.example.security.jwt.response.JwtTokenResponse;
import com.example.security.jwt.service.AuthenticationService;
import com.example.security.jwt.service.JwtTokenService;
import com.example.security.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultAuthenticationService implements AuthenticationService {
    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtTokenResponse signUp(SignUpRequest signUpRequest) {
        var username = signUpRequest.getUsername();
        if (!userService.existsByUsername(username)) {
            var user = User
                    .builder()
                    .username(username)
                    .password(signUpRequest.getPassword())
                    .role(signUpRequest.getRole())
                    .build();
            userService.create(user);

            return new JwtTokenResponse(jwtTokenService.generateToken(user));
        } else {
            throw new UsernameDuplicateException(username);
        }

    }

    @Override
    public JwtTokenResponse signIn(SignInRequest signInRequest) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getUsername(),
                        signInRequest.getPassword()
                )
        );
        var userDetails = (UserDetails) authentication.getPrincipal();

        return new JwtTokenResponse(jwtTokenService.generateToken(userDetails));
    }

}
