package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.CustomerVO;

public class CustomerDAO {
	Connection conn;

	public CustomerDAO() throws SQLException {
		try {
			String url = "jdbc:mysql://localhost:3306/banking_db";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected!!!");
		} catch (SQLException e) {
			throw new SQLException("Failed to connect to the database.");
		}
	}

	public void addAccount(CustomerVO customer) throws SQLException {
		try {
			String querry = "INSERT INTO bank_account (account_number, customer_name, contact_no, aadhar_no, customer_dob, account_balance) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(querry);
			ps.setLong(1, customer.getAccount_number());
			ps.setString(2, customer.getCustomer_name());
			ps.setLong(3, customer.getContact_no());
			ps.setLong(4, customer.getAadhar_no());
			ps.setDate(5, java.sql.Date.valueOf(customer.getCustomer_dob()));
			ps.setDouble(6, customer.getAccount_balance());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Error Sql.");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} // TRY
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean fetchAccount(long acno) {
		String query = "SELECT 1 FROM bank_account WHERE account_number=?";
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, acno);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
