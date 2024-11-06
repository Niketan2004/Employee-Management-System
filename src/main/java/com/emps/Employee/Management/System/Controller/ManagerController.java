package com.emps.Employee.Management.System.Controller;

import com.emps.Employee.Management.System.Entity.Employee;
import com.emps.Employee.Management.System.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
@RequestMapping("/manager/")
public class ManagerController {
    @Autowired
    private EmployeeService employeeService;

    // this will show the form for add an employee
    @GetMapping("/showForm")
    public String showForm(Model model) {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        return "showForm";
    }

    // saves the employee and redirecting it to the dashboard
    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        //saves the employee
        employeeService.save(employee);
        // after saving employee it redirects to the dashboard
        return "redirect:/dashboard";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") long id, Model model) {
        // fetch employee details from the database to prepopulate it into html page
        Optional<Employee> emp = employeeService.findById(id);
        // after fetching it is added to model for displaying it into html page
        model.addAttribute("employee", emp);
        // send over to employee from
        return "showForm";
    }

}
