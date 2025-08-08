package com.innoxitsolution.spingbootproject.service;

import com.innoxitsolution.spingbootproject.model.EmployeeInfo;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    EmployeeInfo createEmployee(EmployeeInfo employee);

    List<EmployeeInfo> getAllEmployees();

    Optional<EmployeeInfo> getEmployeeById(String id);

    Optional<EmployeeInfo> updateEmployee(String id, EmployeeInfo updatedEmployee);

    Optional<EmployeeInfo> patchEmployee(String id, EmployeeInfo partialEmployee);

    boolean deleteEmployee(String id);

    Optional<EmployeeInfo> getEmployeeById(long id);

    Optional<EmployeeInfo> updateEmployee(long id, EmployeeInfo updatedEmployee);

    Optional<EmployeeInfo> patchEmployee(long id, EmployeeInfo patch);

    boolean deleteEmployee(long id);
}
