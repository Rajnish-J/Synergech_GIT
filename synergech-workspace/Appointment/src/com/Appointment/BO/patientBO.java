package com.Appointment.BO;

import java.sql.SQLException;
import java.util.List;

import com.Appointment.DAO.IPatientDAO;
import com.Appointment.DAO.patientDAO;
import com.Appointment.VO.PatientVO;
import com.Appointment.customExceptions.EmailException;
import com.Appointment.customExceptions.PasswordException;
import com.Appointment.customExceptions.PatientNotFoundException;
import com.Appointment.customExceptions.UpdateException;
import com.Appointment.customExceptions.phoneNumberException;

public class patientBO {

//	=> empty DAO object
	public IPatientDAO pDAO = null;

//	=> default constructor: which initiates the DAO object
	public patientBO() throws SQLException {
		pDAO = new patientDAO();
	}

//	=> save patient method : BO
	public boolean savePatientDetails(PatientVO vo)
			throws SQLException, PatientNotFoundException, phoneNumberException, EmailException, PasswordException {
		validatePhoneNumber(vo.getP_phone());
		validateEmail(vo.getP_email());
		validatePassword(vo.getP_password());
		boolean flag = pDAO.savePatientDetails(vo);

		return flag;
	}

//	=> fetch by ID: BO
	public PatientVO fetchByID(int id) throws SQLException {
		return pDAO.fetchById(id);
	}

	// => fetch all method: BO
	public List<PatientVO> fetchall() throws SQLException {
		return pDAO.fetchAllPatient();
	}

//	=> update method : BO
	public boolean updatePatientDetails() throws SQLException, UpdateException {
		patientDAO pdao = new patientDAO();
		boolean flag = pdao.updatePatientDetails();
		return flag;
	}

//	=> validation methods:

//	=> validate phone number method:
	public void validatePhoneNumber(String no) throws phoneNumberException {
		if (no.length() != 10) {
			throw new phoneNumberException("Entered phone number length is not equal to ten");
		}
	}

//	=> validate email method:
	public void validateEmail(String email) throws EmailException {
		if (!(email.contains("@"))) {
			throw new EmailException("Error in email");
		}
	}

//	=> validate password method:
	public void validatePassword(String pass) throws PasswordException {
		boolean flag = false;

		int smallcase = 0, capitalcase = 0, splchar = 0;

		for (int i = 0; i < pass.length(); i++) {
			char ch = pass.charAt(i);
			if (Character.isUpperCase(ch)) {
				capitalcase++;
			} else if (Character.isLowerCase(ch)) {
				smallcase++;
			} else if (ch == '@' || ch == '!' || ch == '&' || ch == '*') {
				splchar++;
			}

			if (capitalcase == 1 && smallcase == 1 && splchar == 1) {
				break;
			}
		}

		if (!(smallcase > 1 && capitalcase > 1 && splchar > 1 && pass.length() == 10)) {
			throw new PasswordException("Enter the password which satisfies for above conditions");
		}
	}

}
