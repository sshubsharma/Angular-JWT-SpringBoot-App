package com.rest.webservices.basic.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth{
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                    .authorizeHttpRequests(
                        auth -> 
                            auth.requestMatchers(HttpMethod.GET, "/**"). permitAll().
                            requestMatchers(HttpMethod.DELETE,"/**").permitAll().
                            requestMatchers(HttpMethod.PUT,"/**").permitAll().
                            requestMatchers(HttpMethod.POST,"/**").permitAll().
                            requestMatchers(HttpMethod.PATCH,"/**").permitAll().
                            requestMatchers(HttpMethod.OPTIONS,"/**").permitAll().
                            anyRequest().authenticated()).httpBasic(Customizer.withDefaults())
                    		.sessionManagement(
                            session -> session.sessionCreationPolicy
                            (SessionCreationPolicy.STATELESS)).
                        csrf().disable();//.authorizeRequests().anyRequest().permitAll();;
                        return http.build();
    }
} 