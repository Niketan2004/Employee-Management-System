package com.emps.Employee.Management.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="emp_id")
    private long id;

    @Column(name = "first_Name", nullable = false)
    private String firstName;

    @Column(name = "last_Name", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "mob_Number", unique = true, nullable = false)
    private String mobNumber;

    @Column(nullable = false)
    private int role;

    @Column(nullable = false)
    private String password;
}
