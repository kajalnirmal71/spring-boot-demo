package com.innoxitsolution.spingbootproject.service;

import com.innoxitsolution.spingbootproject.model.EmployeeInfo;
import com.innoxitsolution.spingbootproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeInfo createEmployee(EmployeeInfo employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeInfo> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeInfo> getEmployeeById(String id) {
        return Optional.empty ();
    }

    @Override
    public Optional<EmployeeInfo> updateEmployee(String id, EmployeeInfo updatedEmployee) {
        return Optional.empty ();
    }

    @Override
    public Optional<EmployeeInfo> patchEmployee(String id, EmployeeInfo partialEmployee) {
        return Optional.empty ();
    }

    @Override
    public boolean deleteEmployee(String id) {
        return false;
    }

    @Override
    public Optional<EmployeeInfo> getEmployeeById(long id) { // ✅ Using long
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<EmployeeInfo> updateEmployee(long id, EmployeeInfo updatedEmployee) { // ✅ Using long
        return employeeRepository.findById(id).map(existing -> {
            existing.setName(updatedEmployee.getName());
            existing.setEmail(updatedEmployee.getEmail());
            existing.setDepartment(updatedEmployee.getDepartment());
            existing.setSalary(updatedEmployee.getSalary());
            return employeeRepository.save(existing);
        });
    }

    @Override
    public Optional<EmployeeInfo> patchEmployee(long id, EmployeeInfo patch) { // ✅ Using long
        return employeeRepository.findById(id).map(existing -> {
            if (patch.getName() != null) existing.setName(patch.getName());
            if (patch.getEmail() != null) existing.setEmail(patch.getEmail());
            if (patch.getDepartment() != null) existing.setDepartment(patch.getDepartment());
            if (patch.getSalary() != 0) existing.setSalary(patch.getSalary());
            return employeeRepository.save(existing);
        });
    }

    @Override
    public boolean deleteEmployee(long id) { // ✅ Using long
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
