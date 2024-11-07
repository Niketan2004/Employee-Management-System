package com.emps.Employee.Management.System.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

public class SecurityConfig {
    //Returns Users and Roles  from Database
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->configurer
                .requestMatchers(HttpMethod.GET, "/emps/employees").permitAll()
                .requestMatchers(HttpMethod.GET, "/emps/employees/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/emps/manager").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/emps/manager").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/emps/admin/**").hasRole("ADMIN")
        );
        //use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable CSRF
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}
