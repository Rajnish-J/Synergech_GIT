package com.presentation.Entity;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false)
    private int employeeAge;

    @Column(nullable = false)
    private long employeeSalary;

    // Getter and Setter methods
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    // toString method


    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}
