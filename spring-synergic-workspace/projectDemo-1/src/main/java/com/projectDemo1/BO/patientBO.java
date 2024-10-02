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
		patientRepo.save(vo);
		return vo.getPatientId();
	}

	// FindByID method:
	public patientVO fetchByID(Long id) {
		patientVO ret = patientRepo.findById(id).get();
		return ret;

	}

	// fetchAll method:
	public List<patientVO> fetchAll() {
		return patientRepo.findAll();
	}

	// update method:
	public boolean updatePatientDetails(long id) {
		patientVO vo = patientRepo.findById(id).get();
		vo.setLastName("Jai");
		patientRepo.save(vo);
		return true;
	}

	// associate method
	public patientVO Associate(patientVO vo) {
		patientVO insert = patientRepo.save(vo);
		return insert;
	}

	// fetch patient by phone number:
	public patientVO fetchbyPhoneNumber(String ph) {
		patientVO vo = patientRepo.findByPhoneNumber(ph);
		return vo;
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

}
