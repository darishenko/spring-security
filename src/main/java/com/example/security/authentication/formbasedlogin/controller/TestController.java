package com.example.security.authentication.formbasedlogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Test";
    }

    @GetMapping("/success")
    public String success() {
        return "Success!";
    }
}
