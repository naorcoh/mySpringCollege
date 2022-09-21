package com.example.SpringBootCollegeApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringCollegeSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .mvcMatchers("/home").authenticated()
                .mvcMatchers("/contact").permitAll()
                .mvcMatchers("/saveMsg").permitAll()
                .mvcMatchers("/courses").permitAll()
                .mvcMatchers("/holidays/**").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/dash").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/dash").failureUrl("/login?error=true").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true).permitAll()
                .and().httpBasic();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        List<UserDetails> userDetails = new ArrayList<>();
        userDetails.add(
                User.withUsername("user")
                        .passwordEncoder(passwordEncoder() :: encode)
                        .password("0000")
                        .roles("USER")
                        .build()
        );

        userDetails.add(
                User.withUsername("admin")
                        .passwordEncoder(passwordEncoder() :: encode)
                        .password("1234")
                        .roles("ADMIN", "USER")
                        .build()
        );

        return new InMemoryUserDetailsManager(userDetails);
    }
}
