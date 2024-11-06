package com.emps.Employee.Management.System.Services;

import com.emps.Employee.Management.System.Entity.Employee;
import com.emps.Employee.Management.System.Repository.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findById(long id) {
        return employeeRepo.findById(id);
    }

    @Override
    public Employee fetchEmployee(String email, String password) {
       return employeeRepo.getEmployeeByUserName(email);
        //return employeeRepo.findById(id);
    }



    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepo.deleteById(id);
    }
}
