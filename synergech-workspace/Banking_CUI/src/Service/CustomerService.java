package Service;

import java.sql.SQLException;

import BO.CustomerBO;
import Response.CustomerResponse;
import VO.CustomerVO;
import exception.AccountException;
import exception.DateException;
import exception.MobileException;

public class CustomerService {
	CustomerBO customerBo;

	public CustomerService() throws SQLException {
		customerBo = new CustomerBO();
	}

	public CustomerResponse addAccount(CustomerVO customer) throws AccountException, DateException, MobileException,
			SQLException, javax.security.auth.login.AccountException {
		try {
			customerBo.addAccount(customer);
			return new CustomerResponse("Account sucessfully Added !!!");
		} catch (SQLException e) {
			throw new SQLException("Failed to connect to the database.", e);
		}
	}

	public CustomerResponse fetchAccount(long acno)
			throws AccountException, javax.security.auth.login.AccountException {
		customerBo.fetchAccount(acno);
		return new CustomerResponse("Account Fetched Sucessfully!!!");
	}
}
