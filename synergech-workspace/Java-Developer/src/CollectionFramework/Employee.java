package CollectionFramework;

public class Employee {
	int EmpID;
	String EmpName;

	public int getEmpID() {
		return EmpID;
	}

	public void setEmpID(int empID) {
		EmpID = empID;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	@Override
	public String toString() {
		return "Employee [EmpID=" + EmpID + ", EmpName=" + EmpName + "]";
	}

}
