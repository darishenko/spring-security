package com.example.security.authentication.httpbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("http-basic")
@SpringBootApplication
public class HttpBasicAuthenticationSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpBasicAuthenticationSpringSecurityApplication.class, args);
	}

}
