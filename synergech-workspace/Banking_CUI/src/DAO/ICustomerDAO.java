package DAO;

import java.sql.SQLException;

import VO.CustomerVO;

public interface ICustomerDAO {
	void addAccount(CustomerVO customer) throws SQLException;

	boolean fetchAccount(long acno);

}
