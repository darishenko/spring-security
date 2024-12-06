package com.example.security.csrf.defaultconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("csrf-default")
@SpringBootApplication
public class DefaultCsrfConfigurationSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DefaultCsrfConfigurationSpringSecurityApplication.class, args);
	}

}
