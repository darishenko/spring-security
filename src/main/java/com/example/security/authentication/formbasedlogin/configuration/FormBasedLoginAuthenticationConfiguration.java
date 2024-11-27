package com.example.security.authentication.formbasedlogin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableWebSecurity
public class FormBasedLoginAuthenticationConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .requestCache(cache ->
                        cache.requestCache(new NullRequestCache()))
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/success")
                        .failureUrl("/login?error=true"))
                .logout(logout -> logout
                        .logoutUrl("/custom/logout").permitAll()
                        .logoutSuccessUrl("/success"))
                .authorizeHttpRequests(request -> request
                        .anyRequest().authenticated())
                .build();
    }

}
