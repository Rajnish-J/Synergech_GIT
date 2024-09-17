package JDBC_assn;

import java.sql.Date;
import java.util.Calendar;

public class StudentMain {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		dao.getStudentDetails();

		StudentVO SVO = new StudentVO();
		SVO.setId(4);
		SVO.setName("Tom");

		Calendar cal = Calendar.getInstance();
		cal.set(cal.YEAR, 2006);
		cal.set(cal.MONTH, cal.JULY);
		cal.set(cal.DATE, 18);

		SVO.setDob(new Date(cal.getTime().getTime()));
		dao.StoreStudentDetails(SVO);
	}
}
