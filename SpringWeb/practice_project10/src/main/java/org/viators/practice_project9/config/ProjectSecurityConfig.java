package org.viators.practice_project9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // Will permit every http request inside web application.
        http.authorizeHttpRequests(request -> request
                .anyRequest().permitAll())
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults());

        // Will deny every http request inside web application.
//        http.authorizeHttpRequests(request -> request
//                        .anyRequest().denyAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
