package com.projectDemo1.BO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectDemo1.DAO.PatientProjection;
import com.projectDemo1.DAO.patientRepo;
import com.projectDemo1.Entity.patientVO;
import com.projectDemo1.customExceptions.AppointmentException;
import com.projectDemo1.customExceptions.EmailException;
import com.projectDemo1.customExceptions.IdException;
import com.projectDemo1.customExceptions.PasswordException;
import com.projectDemo1.customExceptions.PhoneNumberException;
import com.projectDemo1.customExceptions.patientException;

@Component
public class patientBO {

	@Autowired
	patientRepo patientRepo;

	// Insert method:
	public patientVO insertPatientDetails(patientVO vo)
			throws patientException, PhoneNumberException, EmailException, PasswordException {
		if (validatePatient(vo)) {
			vo = patientRepo.save(vo);
			return vo;
		} else {
			throw new patientException("Error in creating patient account..");
		}
	}

	// FindByID method:
	public patientVO fetchByID(Long id) throws IdException {
		if (validateID(id)) {
			patientVO ret = patientRepo.findById(id).get();
			return ret;
		}
		return null;

	}

	// fetchAll method:
	public List<patientVO> fetchAll() {
		return patientRepo.findAll();
	}

	// update method:
	public patientVO updatePatientDetails(long id) throws IdException {
		if (validateID(id)) {
			patientVO vo = patientRepo.findById(id).get();
			vo.setLastName("Jai");
			vo = patientRepo.save(vo);
			return vo;
		}
		return null;
	}

	// associate method
	public patientVO Associate(patientVO vo)
			throws patientException, PhoneNumberException, EmailException, PasswordException, AppointmentException {
		if (validatePatient(vo) && validateAppointmentCount(vo)) {
			patientVO insert = patientRepo.save(vo);
			return insert;
		}
		return null;
	}

	// fetch patient by phone number:
	public patientVO fetchbyPhoneNumber(String ph) throws PhoneNumberException {
		if (validatePhoneNumber(ph)) {
			patientVO vo = patientRepo.findByPhoneNumber(ph);
			return vo;
		}
		return null;
	}

	// fetch by day appointments:
	public List<patientVO> fetchapptDay(LocalDate td) {
		List<patientVO> list = patientRepo.findPatientsWithAppointmentsDay(td);
		return list;
	}

	// fetch by more appointments
	public List<patientVO> fetchappointByNumber(long n) {
		List<patientVO> list = patientRepo.findPatientsWithMoreThanNAppointments(n);
		return list;
	}

	// fetch first name and last name:
	public PatientProjection findname(long n) {
		PatientProjection po = patientRepo.findNameOfPatientById(n);
		return po;
	}

	// Appointment by between two days:
	public List<patientVO> betweenTwoDOBpat(LocalDate sd, LocalDate ld) {
		List<patientVO> list = patientRepo.fetchBetweenDOBpat(sd, ld);
		return list;
	}

	// ascending order:
	public List<patientVO> ascending() {
		List<patientVO> list = patientRepo.fetchAscending();
		return list;
	}

	// validation methods:
	public boolean validatePhoneNumber(String phoneNumber) throws PhoneNumberException {
		if (phoneNumber == null || phoneNumber.length() != 10) {
			throw new PhoneNumberException("ERROR: The phone number lenght is atleast 10");
		}
		for (char c : phoneNumber.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new PhoneNumberException("ERROR: phone number does not have any alphabets");
			}
		}
		return true;
	}

	public boolean validateEmail(String email) throws EmailException {
		if (email == null || email.isEmpty()) {
			throw new EmailException("ERROR: Email field could not be empty");
		}
		int atCount = 0;
		for (char c : email.toCharArray()) {
			if (c == '@') {
				atCount++;
				if (atCount == 1) {
					break;
				}
			}
		}
		if (atCount == 0) {
			throw new EmailException("ERROR: Email should contain atleast one " + "@" + " charactre in it");
		}
		return atCount == 1;
	}

	public boolean validatePassword(String password) throws patientException, PasswordException {

		if (password == null) {
			throw new PasswordException("ERROR: password field could not be empty");
		} else if (password.length() < 8 || password.length() > 12) {
			throw new PasswordException("ERROR: password length in between 8 to 12");
		}

		boolean hasUppercase = false;
		boolean hasLowercase = false;
		boolean hasDigit = false;
		boolean hasSpecial = false;

		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c)) {
				hasUppercase = true;
			} else if (Character.isLowerCase(c)) {
				hasLowercase = true;
			} else if (Character.isDigit(c)) {
				hasDigit = true;
			} else {
				hasSpecial = true;
			}
		}
		if (!(hasUppercase)) {
			throw new PasswordException("ERROR: password could have atleast one Uppercase letter");
		}
		if (!(hasLowercase)) {
			throw new PasswordException("ERROR: password could have atleast one Lowercase letter");
		}
		if (!(hasDigit)) {
			throw new PasswordException("ERROR: password could have atleast one Digit");
		}
		if (!(hasSpecial)) {
			throw new PasswordException("ERROR: password could have atleast one Special character");
		}

		return hasUppercase && hasLowercase && hasDigit && hasSpecial;
	}

	public boolean validateID(Long id) throws IdException {
		if (id == null) {
			throw new IdException("ERROR: patient Id field could not be null");
		} else if (id <= 0) {
			throw new IdException("ERROR: patient ID could not be negative or zero");
		}

		return id != null && id > 0;
	}

	public boolean validateAppointmentCount(patientVO vo) throws AppointmentException {
		if (vo.getAppointments().size() <= 0) {
			throw new AppointmentException("ERROR: Appointments could not be zero..");
		}
		return vo.getAppointments().size() > 0;
	}

	// Main validation method to validate a patient object:
	public boolean validatePatient(patientVO vo)
			throws patientException, PhoneNumberException, EmailException, PasswordException {
		return validatePhoneNumber(vo.getPatientPhone()) && validateEmail(vo.getPatientEmail())
				&& validatePassword(vo.getPatientPassword());
	}
}
