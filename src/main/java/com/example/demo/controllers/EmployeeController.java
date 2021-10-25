package com.example.demo.controllers;

import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepo = new EmployeeRepository();

    @GetMapping("/employees")
    public String allEmployees(Model employeeModel) {
        var allEmployees = employeeRepo.getAllEmployees();
        employeeModel.addAttribute("employees", allEmployees);
        return "employees";
    }
}
