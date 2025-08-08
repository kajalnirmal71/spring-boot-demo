package com.innoxitsolution.spingbootproject.repository;

import com.innoxitsolution.spingbootproject.model.EmployeeInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeInfo employee1;
    private EmployeeInfo employee2;

    @BeforeEach
    void setUp() {
        employeeRepository.deleteAll();

        employee1 = new EmployeeInfo();
        employee1.setName("John Doe");
        employee1.setEmail("john@example.com");
        employee1.setDepartment("IT");
        employee1.setSalary(50000.0);

        employee2 = new EmployeeInfo();
        employee2.setName("Jane Smith");
        employee2.setEmail("jane@example.com");
        employee2.setDepartment("HR");
        employee2.setSalary(60000.0);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }

    @Test
    void testSaveEmployee() {
        EmployeeInfo employee = new EmployeeInfo();
        employee.setName("Mike Ross");
        employee.setEmail("mike@example.com");
        employee.setDepartment("Finance");
        employee.setSalary(70000.0);

        EmployeeInfo saved = employeeRepository.save(employee);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    void testFindAllEmployees() {
        List<EmployeeInfo> employees = employeeRepository.findAll();
        assertThat(employees).hasSize(2);
    }

    @Test
    void testFindById() {
        Optional<EmployeeInfo> employee = employeeRepository.findById(employee1.getId());
        assertThat(employee).isPresent();
        assertThat(employee.get().getName()).isEqualTo("John Doe");
    }

    @Test
    void testUpdateEmployee() {
        EmployeeInfo existing = employeeRepository.findById(employee1.getId()).orElseThrow();
        existing.setSalary(55000.0);
        employeeRepository.save(existing);

        EmployeeInfo updated = employeeRepository.findById(employee1.getId()).orElseThrow();
        assertThat(updated.getSalary()).isEqualTo(55000.0);
    }

    @Test
    void testDeleteEmployee() {
        employeeRepository.deleteById(employee1.getId());
        Optional<EmployeeInfo> deleted = employeeRepository.findById(employee1.getId());
        assertThat(deleted).isNotPresent();
    }
}
