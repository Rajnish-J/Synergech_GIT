package com.Appointment.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Appointment.VO.PatientVO;
import com.Appointment.customExceptions.PatientNotFoundException;
import com.Appointment.customExceptions.UpdateException;

public class patientDAO implements IPatientDAO {
	static Scanner sc = new Scanner(System.in);
	static Connection conn = null;

	// if the object created, this constructor calls and initiate all the JDBC - DB
	// connection process:
	public patientDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/appointment";
		String username = "root";
		String password = "root";
		conn = DriverManager.getConnection(url, username, password);
	}

	// => save patient details method => DAO
	@Override
	public boolean savePatientDetails(PatientVO vo) throws SQLException, PatientNotFoundException {
		boolean flag = false;
		String query = "INSERT INTO patients (patientID, FirstName, LastName, DateOfBirth, P_Phone, P_Email, P_Password) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, vo.getPatientId());
			ps.setString(2, vo.getfName());
			ps.setString(3, vo.getlName());
			ps.setString(4, vo.getDob());
			ps.setString(5, vo.getP_phone());
			ps.setString(6, vo.getP_email());
			ps.setString(7, vo.getP_password());
			int check = ps.executeUpdate();
			if (check == 1)
				flag = true;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new PatientNotFoundException("Error in adding patient details", e);
			}
		}

		return flag;
	}

	// fetch by ID method: DAO
	@Override
	public PatientVO fetchById(int id) throws SQLException {
		PatientVO ret = new PatientVO();

		String query = "SELECT PatientID, FirstName, LastName, DateOfBirth, P_Phone, P_Email, P_Password FROM appointment.patients where PatientID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ret.setPatientId(rs.getInt(1));
				ret.setfName(rs.getString(2));
				ret.setlName(rs.getString(3));
				ret.setDob(rs.getString(4));
				ret.setP_phone(rs.getString(5));
				ret.setP_email(rs.getString(6));
				ret.setP_password(rs.getString(7));
			}
		} finally {
			if (conn != null)
				conn.close();
		}

		return ret;
	}

	// => fetch all method : DAO
	@Override
	public List<PatientVO> fetchAllPatient() throws SQLException {
		List<PatientVO> ret = new ArrayList<PatientVO>();

		String query = "SELECT PatientID, FirstName, LastName, DateOfBirth, P_Phone, P_Email, P_Password FROM appointment.patients";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PatientVO p = new PatientVO();

				p.setPatientId(rs.getInt(1));
				p.setfName(rs.getString(2));
				p.setlName(rs.getString(3));
				p.setDob(rs.getString(4));
				p.setP_phone(rs.getString(5));
				p.setP_email(rs.getString(6));
				p.setP_password(rs.getString(7));

				ret.add(p);

			}
		} finally {
			if (conn != null)
				conn.close();
		}

		return ret;
	}

	@Override
	public boolean updatePatientDetails() throws SQLException, UpdateException {
		boolean repeat_update = true;
		boolean flag = false;
		while (repeat_update) {
			System.out.println("Update options");
			System.out.println("1. Update First name\n2. Update Second name\n3. Exit");
			System.out.println("Enter the update option: ");
			int u_option = sc.nextInt();
			switch (u_option) {
			case 1: {
				System.out.print("Enter the patient ID");
				int id = sc.nextInt();
				System.out.println("Enter the first name: ");
				String fname = sc.next();
				flag = updateFirstName(fname, id);
				break;
			}
			case 2: {
				System.out.print("Enter the patient ID");
				int id = sc.nextInt();
				System.out.println("Enter the first name: ");
				String lname = sc.next();
				flag = updateLastName(lname, id);
				break;
			}
			case 3: {
				repeat_update = false;
				System.out.println("Redirecting to main page");
				break;
			}
			}
		}
		return flag;

	}

	public static boolean updateFirstName(String fname, int id) throws SQLException, UpdateException {
		boolean flag = false;

		String query = "UPDATE appointment.patients SET firstname = ? WHERE PatientID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, fname);
			ps.setInt(2, id);
			int a = ps.executeUpdate();
			if (a == 1) {
				flag = true;
			}
			System.out.println("First name changed");
		} catch (SQLException e) {
			throw new UpdateException("Error in updating");
		} finally {
			if (conn != null)
				conn.close();
		}
		return flag;
	}

	public static boolean updateLastName(String lname, int id) throws SQLException, UpdateException {
		boolean flag = false;

		String query = "UPDATE appointment.patients SET lastname = ? WHERE PatientID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, lname);
			ps.setInt(2, id);
			int a = ps.executeUpdate();
			if (a == 1) {
				flag = true;
			}
			System.out.println("Last name changed");
		} catch (SQLException e) {
			throw new UpdateException("Error in updating");
		} finally {
			if (conn != null)
				conn.close();
		}
		return flag;
	}

}
