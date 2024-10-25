package com.Check.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Check.BO.PatientBO;
import com.Check.CustomExceptions.AppointmentBookingDateException;
import com.Check.CustomExceptions.AppointmentException;
import com.Check.CustomExceptions.DateException;
import com.Check.CustomExceptions.DateOfBirthException;
import com.Check.CustomExceptions.EmailException;
import com.Check.CustomExceptions.IdException;
import com.Check.CustomExceptions.PasswordException;
import com.Check.CustomExceptions.PatientException;
import com.Check.CustomExceptions.PhoneNumberException;
import com.Check.Entity.PatientVO;
import com.Check.Repo.PatientProjection;
import com.Check.Response.ResponseHandle;

import jakarta.transaction.Transactional;

@Service
public class PatientService {
	@Autowired
	private PatientBO patientBO;

	@Autowired
	private ResponseHandle response;

	// insert method
	@Transactional
	public ResponseHandle insertPatientDetails(PatientVO vo)
			throws PatientException, PhoneNumberException, EmailException, PasswordException, DateOfBirthException {
		PatientVO flag = patientBO.insertPatientDetails(vo);
		if (flag != null) {
			response.setSucessMessage("patient Details added successfully");
			response.setPatient(flag);
		} else {
			response.setFailureMessage("Error in fetching...");
		}
		return response;
	}

	// find by Id method:
	@Transactional
	public ResponseHandle fetchById(long id) throws IdException {
		PatientVO vo = patientBO.fetchByID(id);
		if (vo != null) {
			response.setPatient(vo);
			response.setId(vo.getPatientId());
			response.setSucessMessage("patient details fetched by Patient ID: ");
		} else {
			response.setFailureMessage("Error in fetching...");
		}
		return response;
	}

	// fetch all method:
	@Transactional
	public ResponseHandle fetchAll() {
		List<PatientVO> list = patientBO.fetchAll();
		if (list.size() > 0) {
			response.setListPatient(list);
			response.setSucessMessage("Fetching all the patiend details is successfully executed");
		} else {
			response.setFailureMessage("Error in fetching...");
		}
		return response;
	}

	// update method
	@Transactional
	public ResponseHandle updatePatientDetails(long id) throws IdException {
		PatientVO flag = patientBO.updatePatientDetails(id);
		if (flag != null) {
			response.setSucessMessage("updated the patient details successfully for the patient ID: ");
			response.setPatient(flag);
		} else {
			response.setFailureMessage("error in updating patient details");
		}
		return response;
	}

	// Associate method:
	@Transactional
	public ResponseHandle associate(PatientVO vo) throws PatientException, PhoneNumberException, EmailException,
			PasswordException, AppointmentException, AppointmentBookingDateException, DateOfBirthException {
		PatientVO inserted = patientBO.associate(vo);
		if (inserted != null) {
			response.setSucessMessage("Appointment added successfully");
			response.setPatient(inserted);
			response.setId(inserted.getPatientId());
		} else {
			response.setFailureMessage("Failed to add data");
		}
		return response;
	}

	// find by patient phone number:
	public ResponseHandle findbyphone(String ph) throws PhoneNumberException {
		PatientVO vo = patientBO.fetchbyPhoneNumber(ph);
		if (vo != null) {
			response.setPatient(vo);
			response.setSucessMessage("patient details fetched by phone number");
		} else {
			response.setFailureMessage("Error in fetching...");
		}
		return response;
	}

	// fetch by day appointments:
	public ResponseHandle findapptDay(LocalDate td) throws AppointmentException {
		List<PatientVO> list = patientBO.fetchapptDay(td);
		if (list.size() > 0) {
			response.setListPatient(list);
			response.setSucessMessage("fetching the appoinment details within the day is successfully executed");
		} else {
			response.setFailureMessage("There is no appointments on the day...");
		}
		return response;
	}

	// fetch first name and last name:
	public ResponseHandle findName(long n) throws IdException {
		PatientProjection p = patientBO.findname(n);
		if (p != null) {
			response.setPro(p);
			response.setSucessMessage("fetching patient first name and last name is successfully executed");
		} else {
			response.setFailureMessage("Error in fetching...");
		}
		return response;
	}

	// Appointment by between two days:
	public ResponseHandle betweenTwoDOBpat(LocalDate sd, LocalDate ld) throws DateException {
		List<PatientVO> list = patientBO.betweenTwoDOBpat(sd, ld);
		if (list.size() > 0) {
			response.setListPatient(list);
			response.setSucessMessage(
					"fetching patient details between the two dates with respect to DOB is successfully executed");
		} else {
			response.setFailureMessage("Error in fetching...");
		}
		return response;
	}

	// ascending order:
	public ResponseHandle ascending() throws AppointmentException {
		List<PatientVO> list = patientBO.ascending();
		if (list.size() > 0) {
			response.setListPatient(list);
			response.setSucessMessage("fetching the paitent details in ascending order is successfully executed");
		} else {
			response.setFailureMessage("Error in fetching...");
		}
		return response;
	}
}
