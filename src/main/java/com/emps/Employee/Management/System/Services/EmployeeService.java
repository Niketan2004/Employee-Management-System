package com.emps.Employee.Management.System.Services;

import com.emps.Employee.Management.System.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll(); //RETURNS ALL THE EMPLOYEES WITH THERE ROLE
    public Optional<Employee> findById(long id);
    //public Employee fetchEmployee(String email,String password); // WILL BE USED FOR LOGIN
    public Employee save(Employee employee); // insert and update
    public void deleteById(Long id); // DELETES THE EMPLOYEE

}
