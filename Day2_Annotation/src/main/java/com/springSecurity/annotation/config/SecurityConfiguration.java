package com.springSecurity.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("test").password(passwordEncoder().encode("test"))
                .authorities("ROLE_ADMIN");

        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("test"))
                .authorities("ROLE_USER");
    }

    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')").and().formLogin();

        http.authorizeRequests().antMatchers("/user").access("hasRole('USER')").and().formLogin();
    }

}
