package com.emps.Employee.Management.System.Controller;

import com.emps.Employee.Management.System.Entity.Employee;
import com.emps.Employee.Management.System.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/emps/")
public class DashboardController {
    @Autowired
    private EmployeeService employeeService;

    // redirecting from root to login page
    @GetMapping("/")
    public String defaultRedirect() {
        return "redirect:/login";
    }

    //signup page will be shown
    @GetMapping("/signup")
    public String signup() {
        return "Signup";
    }

    // login page will be shown
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //after login in it will show the dashboard where all the employees will be shown in the list form
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Employee> emp = employeeService.findAll();
        model.addAttribute("employees", emp);
        return "dashboard";
    }
}
