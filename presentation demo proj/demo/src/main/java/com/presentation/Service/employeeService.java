package com.presentation.Service;

import com.presentation.DAO.EmployeeDAO;
import com.presentation.Entity.Employee;
import com.presentation.DAO.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employeeService {

    @Autowired
    private EmployeeDAO employeeRepository; // DAO layer (Repository)

    // Save Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee by ID
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            employee.setEmpId(id);
            return employeeRepository.save(employee);
        }
        return null; // Return null if not found
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false; // Return false if employee not found
    }
}
