package com.emps.Employee.Management.System.Repository;

import com.emps.Employee.Management.System.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
//    Employee getEmployeeByUserName(String email);
}
