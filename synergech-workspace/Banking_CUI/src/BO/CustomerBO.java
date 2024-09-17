package BO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.security.auth.login.AccountException;

import DAO.CustomerDAO;
import DAO.ICustomerDAO;
import VO.CustomerVO;
import exception.DateException;
import exception.MobileException;

public class CustomerBO {
	public ICustomerDAO cusDAO;

	public CustomerBO() throws SQLException {
		cusDAO = (ICustomerDAO) new CustomerDAO();
	}

	public void addAccount(CustomerVO customer) throws AccountException, DateException, MobileException, SQLException {
		validAccount(customer.getAccount_number());
		validDOB(customer.getCustomer_dob());
		validMobile(customer.getContact_no());
		cusDAO.addAccount(customer);
	}

	private void validMobile(long mobile) throws MobileException {
		String mob = mobile + "";
		if (mob.charAt(0) < '5' && mob.length() != 10) {
			throw new MobileException("Invalid Mobile Number ");
		}
	}

	private void validDOB(String dob) throws DateException {
		try {
			LocalDate.parse(dob);
		} catch (DateTimeParseException e) {
			throw new DateException("Enter Valid Date");
		}
	}

	private void validAccount(long accountNumber) throws AccountException {
		String acno = accountNumber + "";
		if (acno == null || acno.length() != 10 || !validExitAccount(accountNumber)) {
			throw new AccountException("In valid Account Number");
		}

	}

	public void fetchAccount(long acno) throws AccountException {
		validAccount(acno);
		if (validExitAccount(acno)) {
			((CustomerDAO) cusDAO).fetchAccount(acno);
		} else {
			throw new AccountException("Account is not Present");
		}
	}

	private boolean validExitAccount(long acno) {
		return cusDAO.fetchAccount(acno);
	}
}
