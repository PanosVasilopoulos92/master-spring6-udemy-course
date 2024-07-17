package org.viators.practice_project12.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.ignoringRequestMatchers("/saveMsg")
                        .ignoringRequestMatchers(PathRequest.toH2Console()))
                .authorizeHttpRequests(requests -> requests.requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/displayMessages").hasRole("ADMIN")
                        .requestMatchers("/messages").hasRole("ADMIN")
                        .requestMatchers("/", "/home").permitAll()
                        .requestMatchers("/holidays/**").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers(PathRequest.toH2Console()).permitAll() // !! Instead of the url "/h2-console" we use this !!
                        .requestMatchers("/assets/**").permitAll())
                .formLogin(loginConfigure -> loginConfigure.loginPage("/login")
                        .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
//                .logout(logoutConfigure -> logoutConfigure.logoutSuccessUrl("/login?logout=true")
//                        .invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());

        http.headers(headersConfig -> headersConfig.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));

        return http.build();
    }

    /**
     * Configures an in-memory user details service with two user accounts:
     * - "Panos" with the password "qwerasdf" and the "USER" role
     * - "Efraim" with the password "12345asdf" and the "USER" and "ADMIN" roles
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder() // for development stage only
                .username("Panos")
                .password("qwerasdf")
                .roles("ADMIN")
                .build();

        UserDetails user1 = User.withDefaultPasswordEncoder() // for development stage only
                .username("Efraim")
                .password("12345asdf")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1, admin);
    }
}
