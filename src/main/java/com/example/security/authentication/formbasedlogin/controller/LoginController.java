package com.example.security.authentication.formbasedlogin.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    String login(Authentication authentication, HttpServletResponse response) throws IOException {
        if (!Objects.isNull(authentication) && authentication.isAuthenticated() &&
                !authentication.getPrincipal().equals("anonymousUser")) {
            response.sendRedirect("success");
        }

        return "login";
    }
}
