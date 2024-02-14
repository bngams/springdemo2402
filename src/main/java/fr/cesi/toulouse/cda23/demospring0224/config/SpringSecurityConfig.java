package fr.cesi.toulouse.cda23.demospring0224.config;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.awt.*;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // filter to intercept TOKEN and connect USER
                .addFilterAfter((servletRequest, servletResponse, filterChain) -> {
                    // Get request HTTP HEADERS
                    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
                    String authorizationHeader = httpRequest.getHeader("Authorization");
                    // is HTTP has header Authorization (with TOKEN)
                    if(!authorizationHeader.isEmpty()) {
                        // remove prefix "BEARER" from TOKEN
                        authorizationHeader.replace("Bearer ", "");
                        // TODO: is token valid
                        boolean tokenValid = true;
                        if (tokenValid) {
                            System.out.println("Tell Spring Security that USER is known => consider it connected");
                            // Do manual user authentication with Token
                            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                                    "USERNAME", null, null);
                            // Inject auth in Spring Security Context
                            SecurityContextHolder.getContext().setAuthentication(auth);
                        }
                    }
                    filterChain.doFilter(servletRequest, servletResponse);
                }, UsernamePasswordAuthenticationFilter.class)
                // manage routing access
                .authorizeHttpRequests(authrequestManager ->
                        authrequestManager
                                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                                .requestMatchers("/public/**").permitAll()
                                .requestMatchers("/auth/**").permitAll()
                                .anyRequest().authenticated()
        );
        return http.build();
    }

}
