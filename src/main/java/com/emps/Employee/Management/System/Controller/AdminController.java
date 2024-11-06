package com.emps.Employee.Management.System.Controller;

import com.emps.Employee.Management.System.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    private EmployeeService employeeService;
    // deleting the employee
    @GetMapping("/delete")
    public String deleteById(@RequestParam("employeeId") long id) {
        // deletes the employee by id
        employeeService.deleteById(id);
        // after deleting the employee it will be redirected to the dashboard page
        return "redirect:/dashboard";
    }
}
