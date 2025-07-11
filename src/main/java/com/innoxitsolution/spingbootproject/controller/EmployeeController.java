package com.innoxitsolution.spingbootproject.controller;

import com.innoxitsolution.spingbootproject.model.Employee;
import com.innoxitsolution.spingbootproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/employee")
    public class EmployeeController {

        @Autowired
       private EmployeeRepository repository;

        // Add new employee
        @PostMapping
        public Employee addEmployee(@RequestBody Employee employee) {
            return repository.save(employee);
        }

        // Get all employees
        @GetMapping
        public List<Employee> getAllEmployees() {
            return repository.findAll();
        }

        // Get employee by ID
        @GetMapping("/{id}")
        public Employee getEmployee(@PathVariable Long id) {
            return repository.findById(id).orElse(null);
        }
    }


