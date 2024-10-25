package final_assignment;

import java.util.ArrayList;
import java.util.List;

public class BulkEmployeeDetailProcessor {

	public static void processEmployee(String employeeRecords) {
		String[] records = employeeRecords.split("\\$"); // Split using dollar sign
		List<EmployeeVO1> validEmployees = new ArrayList<>();
		List<EmployeeVO1> invalidEmployees = new ArrayList<>();

		for (String record : records) {
			String[] fields = record.split("\\|");
			if (fields.length != 4) {
				invalidEmployees.add(new EmployeeVO1(fields[0], fields[1], fields[2], 0));
				continue;
			}

			String empId = fields[0];
			String empName = fields[1];
			String mobileNumber = fields[2];
			double salary;
			boolean isError = false; // Track if this record has errors

			try {
				salary = Double.parseDouble(fields[3]);
			} catch (NumberFormatException e) {
				// Add to invalid if salary is not a valid number
				invalidEmployees.add(new EmployeeVO1(empId, empName, mobileNumber, 0));
				continue;
			}

			// Validate mobile number
			if (mobileNumber.length() != 10 || !mobileNumber.matches("\\d+")) {
				isError = true;
			}

			// Validate empId and salary
			if (empId.startsWith("DE")) {
				if (salary > 20000) {
					isError = true;
				}
			} else if (empId.startsWith("MA")) {
				if (salary < 20000 || salary > 80000) {
					isError = true;
				}
			} else {
				isError = true;
			}

			// Add to appropriate list based on validation
			if (isError) {
				invalidEmployees.add(new EmployeeVO1(empId, empName, mobileNumber, salary));
			} else {
				validEmployees.add(new EmployeeVO1(empId, empName, mobileNumber, salary));
			}
		}

		// Print valid employee records in table format
		System.out.println("Success Records:");
		System.out.println("================================================");
		System.out.printf("%-10s %-15s %-12s %-10s%n", "EmpID", "EmpName", "Mobile", "Salary");
		System.out.println("-------------------------------------------------");
		for (EmployeeVO1 emp : validEmployees) {
			System.out.println(emp);
		}

		// Print invalid employee records in table format
		System.out.println("\nFailure Records:");
		System.out.println("================================================");
		System.out.printf("%-10s %-15s %-12s %-10s%n", "EmpID", "EmpName", "Mobile", "Salary");
		System.out.println("-------------------------------------------------");
		for (EmployeeVO1 emp : invalidEmployees) {
			System.out.println(emp);
		}
	}

	public static void main(String[] args) {
		// Test data
		String employeeData = "DE123|John Doe|9876543210|15000$MA234|Jane Smith|9123456789|50000$DE345|Alice|9998887776|25000$MA456|Bob|1234567890|85000$XX123|Invalid Emp|9991234567|30000";
		processEmployee(employeeData);
	}
}
