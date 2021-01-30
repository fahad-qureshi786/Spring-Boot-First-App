package com.smart.basic.controllers;

import com.smart.basic.model.Employee;
import com.smart.basic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


}
