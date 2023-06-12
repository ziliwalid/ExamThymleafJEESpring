package com.example.examthymleaf.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity

public class SecurityConfig {




    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager manager(){
        return new InMemoryUserDetailsManager(
                User
                        .withUsername("walid")
                        .password(this.passwordEncoder().encode("1234"))
                        .roles("USER","ADMIN")
                        .build(),
                User
                        .withUsername("NormalUser")
                        .password(this.passwordEncoder().encode("1234"))
                        .roles("USER","ADMIN")
                        .build()
        );
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.httpBasic(Customizer.withDefaults());
        http.formLogin();
        http.authorizeHttpRequests((auth)->auth
                .requestMatchers("/")
                .permitAll()
                .requestMatchers("/new")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
        );
        return http.build();
    }




}
