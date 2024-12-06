package com.example.security.jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/user/test")
    public String testRole() {
        return "test";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/method/test")
    public String testRoleMethodLevel() {
        return "test";
    }

}
