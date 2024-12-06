package com.example.security.csrf.customconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("csrf-custom")
@SpringBootApplication
public class CustomCsrfConfigurationSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomCsrfConfigurationSpringSecurityApplication.class, args);
	}

}
