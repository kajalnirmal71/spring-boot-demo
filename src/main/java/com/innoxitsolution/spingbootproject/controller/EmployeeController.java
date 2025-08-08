package com.innoxitsolution.spingbootproject.controller;


import com.innoxitsolution.spingbootproject.model.EmployeeInfo;
import com.innoxitsolution.spingbootproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/api/employees")
    public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

        @PostMapping
        public ResponseEntity<EmployeeInfo> createEmployee(@RequestBody EmployeeInfo employee) {
            EmployeeInfo saved = employeeService.createEmployee(employee);
            return ResponseEntity.ok(saved);
        }

        @GetMapping
        public ResponseEntity<List<EmployeeInfo>> getAllEmployees() {
            return ResponseEntity.ok(employeeService.getAllEmployees());
        }

        @GetMapping("/{id}")
        public ResponseEntity<EmployeeInfo> getEmployeeById(@PathVariable String id) {
            Optional<EmployeeInfo> emp = employeeService.getEmployeeById(id);
            return emp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PutMapping("/{id}")
        public ResponseEntity<EmployeeInfo> updateEmployee(@PathVariable String id, @RequestBody EmployeeInfo updated) {
            Optional<EmployeeInfo> updatedEmp = employeeService.updateEmployee(id, updated);
            return updatedEmp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PatchMapping("/{id}")
        public ResponseEntity<EmployeeInfo> patchEmployee(@PathVariable String id, @RequestBody EmployeeInfo partial) {
            Optional<EmployeeInfo> patched = employeeService.patchEmployee(id, partial);
            return patched.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
            boolean deleted = employeeService.deleteEmployee(id);
            return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        }
    }


