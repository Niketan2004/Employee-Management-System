package com.emps.Employee.Management.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.access.annotation.Secured;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // IS NOT THAT MUCH NECESSARY ONLY FOR EMPLOYEE'S UNIQUENESS
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;   // DEFAULT USERNAME FOR LOGIN PAGE
    @Column(unique = true , nullable = false)
    private String mobNumber;
    @Column(nullable = false)
    private int role;
    // FOR ROLE THERE IS INT THAT IS 0-EMPLOYEE, 1-MANAGER AND 2-ADMIN
    // String[] roles = {"EMPLOYEE","MANAGER","ADMIN"};
    @Column(nullable = false)
    private String password;// PASSWORD WILL BE STORED IN DATABASE IN ENCRYPTED FORM
}
