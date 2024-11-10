package com.hari.service;

import com.hari.model.Employee;
import com.hari.repository.EmployeeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findEmployeeByExample(Employee employee){
        Example<Employee> example =Example.of(employee);
        return employeeRepository.findAll(example);
    }


    public Optional<Employee> findOneEmployeeByExample(Employee employee) {
        Example<Employee> example = Example.of(employee);
        return employeeRepository.findOne(example);
    }

    public List<Employee> findEmployeesWithCustomMatcher(String firstName,
                                                         String department) {
        Employee employee = Employee.builder()
                .firstName(firstName)
                .department(department)
                .build();

        // Create a custom ExampleMatcher
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()                          // Ignore case for all string matches
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)// Use LIKE %value% for strings
                .withIgnoreNullValues()                    // Ignore null values
                .withMatcher("firstName", match -> match.exact()) // But make firstName exact match
                .withMatcher("department", match -> match.contains()); // Department can be partial

        Example<Employee> example = Example.of(employee, matcher);
        return employeeRepository.findAll(example);
    }

    // Count employees matching example
    public long countEmployeesByExample(Employee employee) {
        Example<Employee> example = Example.of(employee);
        return employeeRepository.count(example);
    }

    // Check if any employees match the example
    public boolean existsByExample(Employee employee) {
        Example<Employee> example = Example.of(employee);
        return employeeRepository.exists(example);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
