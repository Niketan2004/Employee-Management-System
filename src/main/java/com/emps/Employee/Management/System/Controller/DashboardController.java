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
@RequestMapping("/emps")
public class DashboardController {
    @Autowired
    private EmployeeService employeeService;

//    @GetMapping("/")
//    public String defaultRedirect() {
//        return "redirect:/emps/login";
//    }

    @GetMapping("/signup")
    public String signup() {
        System.out.println("signup working");
        return "signup";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("login working");
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Employee> emp = employeeService.findAll();
        model.addAttribute("employees", emp);
        return "dashboard";
    }
}
