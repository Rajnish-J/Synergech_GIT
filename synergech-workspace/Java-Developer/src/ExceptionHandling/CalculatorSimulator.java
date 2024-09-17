package ExceptionHandling;

public class CalculatorSimulator {
	public static void main(String[] args) {
		// Test cases
		executeTestCase("Ron", 34000, false); // Test Case 1
		executeTestCase("Tim", 1000, true); // Test Case 2
		executeTestCase("Jack", 55000, true); // Test Case 3
		executeTestCase("", 30000, true); // Test Case 4
	}

	// Method to execute the test cases
	public static void executeTestCase(String empName, double empSal, boolean isIndian) {
		TaxCalculator taxCalculator = new TaxCalculator();
		try {
			double tax = taxCalculator.calculateTax(empName, isIndian, empSal);
			System.out.println("Tax amount is " + tax);
		} catch (CountryNotValidException | EmployeeNameInvalidException | TaxNotEligibleException e) {
			System.out.println(e.getMessage());
		}
	}
}
