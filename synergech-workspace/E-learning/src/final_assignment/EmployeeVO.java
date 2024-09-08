package final_assignment;

public class EmployeeVO {
	private String empId;
	private String empName;
	private String mobileNumber;
	private double salary;

	public EmployeeVO(String empId, String empName, String mobileNumber, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.mobileNumber = mobileNumber;
		this.salary = salary;
	}

//	setters
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	// Getters
	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public double getSalary() {
		return salary;
	}

	// Overriding toString method for easy printing
	@Override
	public String toString() {
		return "EmployeeVO [empId=" + empId + ", empName=" + empName + ", mobileNumber=" + mobileNumber + ", salary="
				+ salary + "]";
	}
}
