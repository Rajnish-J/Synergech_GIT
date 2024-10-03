package com.projectDemo1.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectDemo1.BO.patientBO;
import com.projectDemo1.DAO.PatientProjection;
import com.projectDemo1.Entity.patientVO;
import com.projectDemo1.Response.ResponseHandle;
import com.projectDemo1.customExceptions.AppointmentException;
import com.projectDemo1.customExceptions.EmailException;
import com.projectDemo1.customExceptions.IdException;
import com.projectDemo1.customExceptions.PasswordException;
import com.projectDemo1.customExceptions.PhoneNumberException;
import com.projectDemo1.customExceptions.patientException;

import jakarta.transaction.Transactional;

@Service
public class patientService {
	@Autowired
	private patientBO patientBO;

//	@Autowired
//	private patientDTO patientDTO;

	@Autowired
	private ResponseHandle response;

	// insert method
	@Transactional
	public ResponseHandle insertPatientDetails(patientVO vo)
			throws patientException, PhoneNumberException, EmailException, PasswordException {
		patientVO flag = patientBO.insertPatientDetails(vo);
		if (flag != null) {
			response.setSucessmessage("patient Details added successfully");
			response.setPatient(flag);
		} else {
			response.setFailuremessage("Error in fetching...");
		}
		return response;
	}

	// find by Id method:
	@Transactional
	public ResponseHandle fetchById(long id) throws IdException {
		patientVO vo = patientBO.fetchByID(id);
		if (vo != null) {
			response.setPatient(vo);
			response.setSucessmessage("patient details fetched by Patient ID");
		} else {
			response.setFailuremessage("Error in fetching...");
		}
		return response;
	}

	// fetch all method:
	@Transactional
	public ResponseHandle fetchAll() {
		List<patientVO> list = patientBO.fetchAll();
		if (list.size() > 0) {
			response.setListpatient(list);
			response.setSucessmessage("Fetching all the patiend details is successfully executed");
		} else {
			response.setFailuremessage("Error in fetching...");
		}

		return response;
	}

	// update method
	@Transactional
	public ResponseHandle updatePatientDetails(long id) throws IdException {
		patientVO flag = patientBO.updatePatientDetails(id);
		if (flag != null) {
			response.setSucessmessage("updated the patient details successfully");
			response.setPatient(flag);
		} else {
			response.setFailuremessage("error in updating patient details");
		}

		return response;
	}

	// Associate method:
	@Transactional
	public ResponseHandle associate(patientVO vo)
			throws patientException, PhoneNumberException, EmailException, PasswordException, AppointmentException {
		patientVO inserted = patientBO.Associate(vo);
		long id = inserted.getPatientId();

		if (id > 0) {
			response.setSucessmessage("Appointment added successfully");
			response.setId(id);
		} else {
			response.setFailuremessage("Failed to add data");
		}

		return response;
	}

	// find by patient phone number:
	public ResponseHandle findbyphone(String ph) throws PhoneNumberException {
		patientVO vo = patientBO.fetchbyPhoneNumber(ph);
		if (vo != null) {
			response.setPatient(vo);
			response.setSucessmessage("patient details fetched by phone number");
		} else {
			response.setFailuremessage("Error in fetching...");
		}
		return response;

	}

	// fetch by day appointments:
	public ResponseHandle findapptDay(LocalDate td) {
		List<patientVO> list = patientBO.fetchapptDay(td);
		if (list.size() > 0) {
			response.setListpatient(list);
			response.setSucessmessage("fetching the appoinment details with the patient ID is successfully executed");
		} else {
			response.setFailuremessage("Error in fetching...");
		}
		return response;
	}

	// fetch by more appointments
	public ResponseHandle findAppointmentsByNumber(long n) {
		List<patientVO> list = patientBO.fetchappointByNumber(n);
		if (list.size() > 0) {
			response.setListpatient(list);
			response.setSucessmessage("fetching the appoinment details with the patient ID is successfully executed");
		} else {
			response.setFailuremessage("Error in fetching...");
		}
		return response;
	}

	// fetch first name and last name:
	public ResponseHandle findName(long n) {
		PatientProjection p = patientBO.findname(n);
		if (p != null) {
			response.setPro(p);
			response.setSucessmessage("fetching patient first name and last name is successfully executed");
		} else {
			response.setFailuremessage("Error in fetching...");
		}
		return response;
	}

	// Appointment by between two days:
	public ResponseHandle betweenTwoDOBpat(LocalDate sd, LocalDate ld) {
		List<patientVO> list = patientBO.betweenTwoDOBpat(sd, ld);
		if (list.size() > 0) {
			response.setListpatient(list);
			response.setSucessmessage(
					"fetching patient details between the two dates with respect to DOB is successfully executed");
		} else {
			response.setFailuremessage("Error in fetching...");
		}
		return response;
	}

	// ascending order:
	public ResponseHandle acending() {
		List<patientVO> list = patientBO.ascending();
		if (list.size() > 0) {
			response.setListpatient(list);
			response.setSucessmessage("fetching the paitent details in ascending order is successfully executed");
		} else {
			response.setFailuremessage("Error in fetching...");
		}
		return response;
	}
}
