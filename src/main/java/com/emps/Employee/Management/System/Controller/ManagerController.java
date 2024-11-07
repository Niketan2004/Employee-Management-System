package com.emps.Employee.Management.System.Controller;

import com.emps.Employee.Management.System.Entity.Employee;
import com.emps.Employee.Management.System.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        return "showForm";
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/emps/dashboard";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") long id, Model model) {
        Optional<Employee> emp = employeeService.findById(id);
        if (emp.isPresent()) {
            model.addAttribute("employee", emp.get());
            return "showForm";
        } else {
            return "redirect:/emps/dashboard";
        }
    }
}
