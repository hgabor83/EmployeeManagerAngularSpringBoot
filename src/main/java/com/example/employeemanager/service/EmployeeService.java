package com.example.employeemanager.service;

import java.util.List;
import java.util.UUID;

import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepo;

    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepo = employeeRepository;
    }

    public Employee addEmployee(final Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(final Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("This userID " + id + " cannot be found"));
    }

    public Employee updateEmployee(final Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(final Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
