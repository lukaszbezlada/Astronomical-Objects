package com.lukaszbezlada.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/oldApi/**", "/api/**").permitAll()
                .antMatchers( "/static/**", "/css/**", "/img/**", "/js/**","/scss/**","/vendor/**").permitAll()
                .antMatchers(HttpMethod.POST, "/registration").permitAll()
                .antMatchers("/", "/registration", "/messierdirectory", "/addUser").permitAll()
                .antMatchers("/users", "/allskyobjects").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/skyobjects").permitAll()
                .failureUrl("/failure")
                .and()
                .logout().logoutUrl("/logmeout").logoutSuccessUrl("/").permitAll();
    }
}