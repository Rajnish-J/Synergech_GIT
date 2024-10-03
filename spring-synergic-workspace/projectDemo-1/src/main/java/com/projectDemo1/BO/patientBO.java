package com.projectDemo1.BO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projectDemo1.DAO.PatientProjection;
import com.projectDemo1.DAO.patientRepo;
import com.projectDemo1.Entity.patientVO;

@Component
public class patientBO {

	@Autowired
	patientRepo patientRepo;

	// Insert method:
	public Long insertPatientDetails(patientVO vo) {
		long pId = 0;
		if (validatePatient(vo)) {
			patientRepo.save(vo);
			return vo.getPatientId();
		}
		return pId;
	}

	// FindByID method:
	public patientVO fetchByID(Long id) {
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
	public boolean updatePatientDetails(long id) {
		if (validateID(id)) {
			patientVO vo = patientRepo.findById(id).get();
			vo.setLastName("Jai");
			patientRepo.save(vo);
			return true;
		}
		return false;
	}

	// associate method
	public patientVO Associate(patientVO vo) {
		if (validatePatient(vo) && validateAppointmentCount(vo)) {
			patientVO insert = patientRepo.save(vo);
			return insert;
		}
		return null;
	}

	// fetch patient by phone number:
	public patientVO fetchbyPhoneNumber(String ph) {
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
	public boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() != 10) {
			return false;
		}
		for (char c : phoneNumber.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public boolean validateDOB(LocalDate dob) {
		return dob != null && dob.isBefore(LocalDate.now());
	}

	public boolean validateEmail(String email) {
		if (email == null || email.isEmpty()) {
			return false;
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
		return atCount == 1;
	}

	public boolean validatePassword(String password) {
		if (password == null || password.length() < 8 || password.length() > 12) {
			return false;
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
				hasSpecial = true; // Assume any character that is not a letter or digit is special
			}
		}

		return hasUppercase && hasLowercase && hasDigit && hasSpecial;
	}

	public boolean validateID(Long id) {
		return id != null && id > 0;
	}

//	public boolean validateAppointmentDate(LocalDate appointmentDate) {
//		return appointmentDate != null && !appointmentDate.isBefore(LocalDate.now());
//	}

	public boolean validateAppointmentCount(patientVO vo) {
		return vo.getAppointments().size() > 0;
	}

	// Main validation method to validate a patient object:
	public boolean validatePatient(patientVO vo) {
		return validatePhoneNumber(vo.getPatientPhone()) && validateDOB(vo.getDob())
				&& validateEmail(vo.getPatientEmail()) && validatePassword(vo.getPatientPassword());
	}
}
