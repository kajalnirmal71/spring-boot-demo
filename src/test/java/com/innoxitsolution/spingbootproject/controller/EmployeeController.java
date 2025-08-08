package com.innoxitsolution.spingbootproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innoxitsolution.spingbootproject.model.EmployeeInfo;
import com.innoxitsolution.spingbootproject.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;


    @Autowired
    private ObjectMapper objectMapper;

    private EmployeeInfo employee;

    @BeforeEach
    void setUp() {
        employee = new EmployeeInfo();
        employee.setName("alice Doe");
        employee.setEmail("alice@example.com");
        employee.setDepartment("IT");
        employee.setSalary (55000.00);

    }


    @Test
    void testCreateEmployee() throws Exception {
        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("alice Doe"))
                .andExpect(jsonPath("$.email").value("alice@example.com"))
                .andExpect(jsonPath("$.department").value("IT"));
    }


    @Test
    public void testGetEmployeeById_NotFound() throws Exception {
        String employeeId = "f84b8451-4035-4e6a-ac9c-f4a654e10ec2";

        // Mock the service to return empty
        Mockito.when(employeeService.getEmployeeById(employeeId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/employees/" + employeeId))
                .andExpect(status().isNotFound());





    }

    @Test
    void testUpdateEmployee_NotFound() throws Exception {
        mockMvc.perform(put("/api/employees/{id}", "fake-id")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteEmployee_NotFound() throws Exception {
        mockMvc.perform(delete("/api/employees/{id}", "fake-id"))
                .andExpect(status().isNotFound());
    }
}