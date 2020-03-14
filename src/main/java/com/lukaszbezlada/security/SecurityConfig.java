package com.lukaszbezlada.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
                .antMatchers("/css/**", "/js/**", "/img/**", "/vendor/**", "/scss/**", "/jqery/**","/static/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/messierdirectory").permitAll()
                .antMatchers("/addUser").permitAll()
                .antMatchers("/com/lukaszbezlada/api/**").permitAll()
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/account").permitAll()
                .failureUrl("/failure")
                .and()
                .logout().logoutUrl("/logmeout").logoutSuccessUrl("/").permitAll();
    }
}