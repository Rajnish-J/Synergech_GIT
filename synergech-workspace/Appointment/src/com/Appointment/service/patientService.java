package com.Appointment.service;

import java.sql.SQLException;
import java.util.List;

import com.Appointment.BO.patientBO;
import com.Appointment.VO.PatientVO;
import com.Appointment.customExceptions.AccountcreationException;
import com.Appointment.customExceptions.EmailException;
import com.Appointment.customExceptions.PasswordException;
import com.Appointment.customExceptions.PatientNotFoundException;
import com.Appointment.customExceptions.UpdateException;
import com.Appointment.customExceptions.phoneNumberException;

public class patientService {

	private static patientBO pBO;

	public patientService() throws SQLException {
		pBO = new patientBO();
	}

//	=> save method : service layer
	public static String savePatientDetails(PatientVO vo) throws SQLException, PatientNotFoundException,
			phoneNumberException, EmailException, PasswordException, AccountcreationException {
		patientBO pBO_insert = new patientBO();
		String str = "";

		if (pBO_insert.savePatientDetails(vo)) {
			str = "Account added succesfully";
		} else {
			throw new AccountcreationException("Error in creating account");
		}

		return str;
	}

//	=> fetch by ID: service
	public static PatientVO fetchByID(int id) throws SQLException {

		patientBO patient_fetch = new patientBO();
		return patient_fetch.fetchByID(id);

	}

	// => fetch all method: service
	public static List<PatientVO> fetchAll() throws SQLException {
		patientBO pbo = new patientBO();
		return pbo.fetchall();
	}

	// => update patient details method:
	public static boolean updatePatientDetails() throws SQLException, UpdateException {
		patientBO pbo = new patientBO();
		return pbo.updatePatientDetails();
	}
}
