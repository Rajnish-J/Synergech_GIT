package final_assignment;

class EmployeeVO1 {
	String empId;
	String empName;
	String mobileNumber;
	double salary;

	public EmployeeVO1(String empId, String empName, String mobileNumber, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.mobileNumber = mobileNumber;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-15s %-12s %-10.2f", empId, empName, mobileNumber, salary);
	}
}