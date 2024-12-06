package com.example.security.authentication.formbasedlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("form-based-login")
@SpringBootApplication
public class FormBasedLoginAuthenticationSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormBasedLoginAuthenticationSpringSecurityApplication.class, args);
	}

}
