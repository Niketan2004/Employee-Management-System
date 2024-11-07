package com.emps.Employee.Management.System.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/signup", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable(); // Consider enabling CSRF protection in production

        return http.build();
    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // Configure URL access restrictions based on roles
//        http.authorizeRequests(configurer -> configurer
//                .requestMatchers(HttpMethod.GET, "/emps/dashboard").permitAll()
//                .requestMatchers(HttpMethod.GET, "/manager/**").hasRole("MANAGER")
//                .requestMatchers(HttpMethod.POST, "/manager/**").hasRole("MANAGER")
//                .requestMatchers(HttpMethod.DELETE, "/admin/**").hasRole("ADMIN")
//        );
//
//        // Set up custom login page at /signup
//        http.formLogin()
//                .loginPage("/signup")  // Define your custom login page URL here
//                .permitAll();
//
//        // Disable CSRF for now (be careful in production)
//        http.csrf(csrf -> csrf.disable());
//
//        // Enable HTTP basic authentication if needed
//        http.httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
}
