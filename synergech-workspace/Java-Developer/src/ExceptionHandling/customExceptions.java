package ExceptionHandling;

//Custom Exception: CountryNotValidException
class CountryNotValidException extends Exception {
	public CountryNotValidException(String message) {
		super(message);
	}
}

//Custom Exception: EmployeeNameInvalidException
class EmployeeNameInvalidException extends Exception {
	public EmployeeNameInvalidException(String message) {
		super(message);
	}
}

//Custom Exception: TaxNotEligibleException
class TaxNotEligibleException extends Exception {
	public TaxNotEligibleException(String message) {
		super(message);
	}
}
