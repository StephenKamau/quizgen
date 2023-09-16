package com.stephenk.quizgen.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity()
public class AuthConfig {
    private final UserDetailService userDetailService;

    public AuthConfig(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf((config) -> config.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        // .requestMatchers("/api/**").permitAll()
                        // .requestMatchers("/v3/api-docs").permitAll()
                        .anyRequest().permitAll())
                .userDetailsService(userDetailService)
                .httpBasic(Customizer.withDefaults())
                .build();
    }

}
