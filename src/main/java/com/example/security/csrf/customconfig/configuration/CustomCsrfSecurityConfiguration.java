package com.example.security.csrf.customconfig.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class CustomCsrfSecurityConfiguration {
    private static final String CSRF_TOKEN_HEADER_NAME = "X-CUSTOM-CSRF-TOKEN";
    private static final String CSRF_TOKEN_PARAMETER_NAME = "_custom_csrf_parameter";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf
                        .csrfTokenRepository(csrfTokenRepository())
                        .ignoringRequestMatchers("/api/**"))
                // Login page
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/test").permitAll()
                        .anyRequest().authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    private CsrfTokenRepository csrfTokenRepository() {
        var csrfTokenRepository = new CookieCsrfTokenRepository();
        csrfTokenRepository.setHeaderName(CSRF_TOKEN_HEADER_NAME);
        csrfTokenRepository.setParameterName(CSRF_TOKEN_PARAMETER_NAME);

        return csrfTokenRepository;
    }

}
