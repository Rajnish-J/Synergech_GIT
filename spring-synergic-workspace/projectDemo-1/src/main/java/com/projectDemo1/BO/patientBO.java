package com.projectDemo1.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}