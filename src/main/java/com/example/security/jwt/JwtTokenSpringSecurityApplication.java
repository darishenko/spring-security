package com.example.security.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("jwt")
@SpringBootApplication
public class JwtTokenSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtTokenSpringSecurityApplication.class, args);
    }

}
