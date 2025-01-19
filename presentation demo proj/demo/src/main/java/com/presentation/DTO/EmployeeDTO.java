package com.presentation.DTO;

public class EmployeeDTO {

    private Long empId;

    private String employeeName;

    private int employeeAge;

    private long employeeSalary;

    // getter and setter
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

    // toString

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId=" + empId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}
