package final_assignment;

public class EmployeeDetailProcessor {
	// Method to process the employee record string
	public EmployeeVO processEmployee(String s) {
		// Splitting the input string by pipe (|) delimiter
		String[] employeeData = s.split("\\|");

		// Validating if we have all the required fields
		if (employeeData.length != 4) {
			System.out.println("Invalid input format. Correct format: empid|empname|MobileNumber|salary");
			return null;
		}

		String empId = employeeData[0];
		String empName = employeeData[1];
		String mobileNumber = employeeData[2];
		double salary;

		// Validation: Check if the employee ID starts with two alphabets
		if (!(firstTwo(empId))) {
			System.out.println("Invalid Employee ID. It must start with two alphabets.");
			return null;
		}

		// Validation: Check if the mobile number is exactly 10 digits
		if (!(mobileNumber.length() == 10)) {
			System.out.println("Invalid Mobile Number. It must be exactly 10 digits.");
			return null;
		}

		try {
			// Parse the salary value
			salary = Double.parseDouble(employeeData[3]);
		} catch (NumberFormatException e) {
			System.out.println("Invalid salary. It must be a numeric value.");
			return null;
		}

		// => If all validations pass, create and return an EmployeeVO object
		return new EmployeeVO(empId, empName, mobileNumber, salary);
	}

	public static boolean firstTwo(String str) {
		boolean ret = true;
		String twoChar = str.substring(0, 2);
		for (int i = 0; i < twoChar.length(); i++) {
			char ch = twoChar.charAt(i);
			if (!(Character.isAlphabetic(ch))) {
				ret = false;
				break;
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		// Create an instance of EmployeeDetailProcessor
		EmployeeDetailProcessor processor = new EmployeeDetailProcessor();

		// Example employee record input
		String employeeRecord = "AB123|John Doe|9876543210|50000";

		// Process the employee record and obtain the EmployeeVO object
		EmployeeVO employee = processor.processEmployee(employeeRecord);

		// If the employee object is created successfully, print it
		if (employee != null) {
			System.out.println("Processed Employee Record: " + employee);
		}
	}
}
