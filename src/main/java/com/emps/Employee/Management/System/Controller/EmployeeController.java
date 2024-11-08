package com.emps.Employee.Management.System.Controller;

import com.emps.Employee.Management.System.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmpService) {
        employeeService = theEmpService;
    }

    @GetMapping("/")
    public String dashboardRedirect() {
        return "redirect:/emps/dashboard";
    }
}
