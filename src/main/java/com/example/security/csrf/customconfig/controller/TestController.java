package com.example.security.csrf.customconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user/test")
    public String test() {
        return "Authorized!";
    }

    @PostMapping("/user/test")
    public String testWithCsrf() {
        return "Authorized. All right with csrf!";
    }

    @PostMapping("/api/user/test")
    public String testIgnoredPath() {
        return "Ignoring!";
    }
}
