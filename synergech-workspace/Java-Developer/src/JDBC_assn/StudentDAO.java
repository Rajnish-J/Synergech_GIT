package JDBC_assn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	public void getStudentDetails() {
		Connection con = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_assn", "root", "root");

			st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT Student_id, Student_name, Date_of_Birth FROM jdbc_assn.student");

			while (rs.next()) {
				System.out.println("Student ID: " + rs.getInt(1) + " Student Name: " + rs.getString(2)
						+ " Date of Birth: " + rs.getDate(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void StoreStudentDetails(StudentVO s) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_assn", "root", "root");

			st = con.prepareStatement("INSERT INTO student (Student_id, Student_name, Date_of_Birth) VALUES (?, ?, ?)");

			st.setInt(1, s.getId());
			st.setString(2, s.getName());
			st.setDate(3, s.getDob());

			int i = st.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Record added");
			}
		}
	}

}
