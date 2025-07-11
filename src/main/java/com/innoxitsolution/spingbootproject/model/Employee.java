package com.innoxitsolution.spingbootproject.model;



import jakarta.persistence.*;

    @Entity
    public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private Double salary;

        // Constructors
        public Employee() {}

        public Employee(String name, Double salary) {
            this.name = name;
            this.salary = salary;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Double getSalary() {
            return salary;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }
    }


