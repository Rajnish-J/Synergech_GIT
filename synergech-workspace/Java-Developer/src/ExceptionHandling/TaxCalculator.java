package ExceptionHandling;

public class TaxCalculator {
	public static double calculateTax(String empName, boolean isIndian, double empSal)
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		double taxAmount = 0;
		// Check if employee name is null or empty
		if (empName == null || empName.isEmpty()) {
			throw new EmployeeNameInvalidException("The employee name cannot be empty.");
		}

		if (empSal > 100000) {
			if (!isIndian) {
				throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax.");
			} else {
				taxAmount = empSal * 8 / 100;
			}
		} else if (empSal >= 50000 && empSal <= 100000) {
			if (!isIndian) {
				throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax.");
			} else {
				taxAmount = empSal * 6 / 100;
			}
		} else if (empSal >= 30000 && empSal < 50000) {
			if (!isIndian) {
				throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax.");
			} else {
				taxAmount = empSal * 5 / 100;
			}
		} else if (empSal >= 10000 && empSal < 30000) {
			if (!isIndian) {
				throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax.");
			} else {
				taxAmount = empSal * 4 / 100;
			}
		} else {
			// If salary is below the taxable range
			throw new TaxNotEligibleException("The employee does not need to pay tax.");
		}

		return taxAmount;
	}
}
