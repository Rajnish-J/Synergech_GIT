package com.presentation.Controller;

import com.presentation.DTO.EmployeeDTO;
import com.presentation.Entity.Employee;
import com.presentation.Service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class employeeController {

    @Autowired
    private employeeService employeeService;

    // Create Employee
    @PostMapping("/addEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            Employee employee = mapToEntity(employeeDTO);
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(mapToDTO(savedEmployee), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating employee", HttpStatus.BAD_REQUEST);
        }
    }

    // Get All Employees
    @GetMapping("/allEmployees")
    public ResponseEntity<?> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            if (employees.isEmpty()) {
                return new ResponseEntity<>("No employees found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving employees", HttpStatus.BAD_REQUEST);
        }
    }

    // Get Employee by ID
    @GetMapping("Employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee == null) {
                return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(mapToDTO(employee), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving employee", HttpStatus.BAD_REQUEST);
        }
    }

    // Update Employee
    @PutMapping("updateEmployee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        try {
            Employee employee = mapToEntity(employeeDTO);
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            if (updatedEmployee == null) {
                return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(mapToDTO(updatedEmployee), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating employee", HttpStatus.BAD_REQUEST);
        }
    }

    // Delete Employee
    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            boolean isDeleted = employeeService.deleteEmployee(id);
            if (!isDeleted) {
                return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting employee", HttpStatus.BAD_REQUEST);
        }
    }

    // Mapping method from Entity to DTO
    private EmployeeDTO mapToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpId(employee.getEmpId());
        employeeDTO.setEmployeeName(employee.getEmployeeName());
        employeeDTO.setEmployeeAge(employee.getEmployeeAge());
        employeeDTO.setEmployeeSalary(employee.getEmployeeSalary());
        return employeeDTO;
    }

    // Mapping method from DTO to Entity
    private Employee mapToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmpId(employeeDTO.getEmpId());
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmployeeAge(employeeDTO.getEmployeeAge());
        employee.setEmployeeSalary(employeeDTO.getEmployeeSalary());
        return employee;
    }
}

