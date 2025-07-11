package com.innoxitsolution.spingbootproject.repository;

import com.innoxitsolution.spingbootproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    }



