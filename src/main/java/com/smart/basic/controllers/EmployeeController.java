package com.smart.basic.controllers;

import com.smart.basic.exceptions.ResourceNotFoundException;
import com.smart.basic.model.Employee;
import com.smart.basic.respositories.EmployeeRepository;
import com.smart.basic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

//    http://localhost:9092/getEmployeeById/1
    @GetMapping("/getEmployeeById/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Integer id){
        return employeeRepository.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not found for id = "+id));
        employeeRepository.deleteById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee neweEployee) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not found for id = "+id));
        employee.setName(neweEployee.getName());
        employee.setDepartment(neweEployee.getDepartment());
        employee.setEmployeeStatus(neweEployee.getEmployeeStatus());
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }



}
