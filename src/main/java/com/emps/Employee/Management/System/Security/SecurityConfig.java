//package com.emps.Employee.Management.System.Security;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
//
//    @SuppressWarnings("deprecation")
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // Configure URL access restrictions based on roles
//        http.authorizeRequests(configurer -> configurer
//                .requestMatchers(HttpMethod.GET, "/emps/dashboard").permitAll()
//                .requestMatchers(HttpMethod.GET, "/emps/signup").permitAll()
//                .requestMatchers(HttpMethod.GET, "/emps/login").permitAll()
//                .requestMatchers(HttpMethod.GET, "/manager/**").hasRole("MANAGER")
//                .requestMatchers(HttpMethod.POST, "/manager/**").hasRole("MANAGER")
//                .requestMatchers(HttpMethod.DELETE, "/admin/**").hasRole("ADMIN")
//        // .and()
//        // .httpBasic()
//        // .and()
//        // .csrf().disable();
//        );
//        // Set up custom login page at /signup
//
//        // Disable CSRF for now (be careful in production)
//        // http.csrf(csrf -> csrf.disable());
//
//        // Enable HTTP basic authentication if needed
//        // http.httpBasic(Customizer.withDefaults());
//
//        return http.build();
//
//    }
//}
