package com.innoxitsolution.spingbootproject.service;

import com.innoxitsolution.spingbootproject.model.EmployeeInfo;
import com.innoxitsolution.spingbootproject.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
 class employeeServiceTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeInfo employee;

    @BeforeEach
    void setUp() {
        employee = new EmployeeInfo();
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
        employee.setDepartment("IT");
        employee.setSalary(50000.0);
    }

    @Test
    @DisplayName("Save Employee - Success")
    void saveEmployee() {
        EmployeeInfo saved = employeeRepository.save(employee);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull(); // Ensure ID is generated
        assertThat(saved.getId()).isGreaterThan(0L);
    }

    @Test
    @DisplayName("Find Employee By ID - Success")
    void findEmployeeById() {
        EmployeeInfo saved = employeeRepository.save(employee);
        Optional<EmployeeInfo> found = employeeRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("John Doe");
    }

    @Test
    @DisplayName("Find All Employees - Success")
    void findAllEmployees() {
        employeeRepository.save(employee);

        List<EmployeeInfo> list = employeeRepository.findAll();

        assertThat(list).isNotEmpty();
        assertThat(list.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("Update Employee - Success")
    void updateEmployee() {
        EmployeeInfo saved = employeeRepository.save(employee);
        saved.setSalary(60000.00);

        EmployeeInfo updated = employeeRepository.save(saved);

        assertThat(updated.getSalary()).isEqualTo(60000);
    }

    @Test
    @DisplayName("Delete Employee - Success")
    void deleteEmployee() {
        EmployeeInfo saved = employeeRepository.save(employee);

        employeeRepository.deleteById(saved.getId());
        Optional<EmployeeInfo> deleted = employeeRepository.findById(saved.getId());

        assertThat(deleted).isEmpty();
    }
}
