function EmployeeDetailFormatter(empID, empName, empContactNumber, empAge) {
  return `Employee Name: ${empName} | Age: ${empAge} | contact:  ${empContactNumber}`;
}

console.log(EmployeeDetailFormatter(1, "Rajnish", "9176960600", "22"));
