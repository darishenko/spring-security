package com.example.security.csrf.defaultconfig.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.*;

import java.util.Set;

@Configuration
@EnableWebSecurity
public class DefaultCsrfSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        final Set<String> ignoringMethods = Set.of("GET", "HEAD", "OPTIONS", "TRACE");

        CsrfTokenRepository csrfTokenRepository = new HttpSessionCsrfTokenRepository();

        return httpSecurity
                .csrf(csrf -> csrf
                        .requireCsrfProtectionMatcher(request -> !ignoringMethods.contains(request.getMethod()))
                        .csrfTokenRepository(csrfTokenRepository)
                        .csrfTokenRequestHandler(new XorCsrfTokenRequestAttributeHandler())
                        .sessionAuthenticationStrategy(new CsrfAuthenticationStrategy(csrfTokenRepository)))
                // Login page
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }
}
