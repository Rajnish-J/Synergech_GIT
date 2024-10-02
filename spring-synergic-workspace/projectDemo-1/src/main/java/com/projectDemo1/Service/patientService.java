package com.projectDemo1.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectDemo1.BO.patientBO;
import com.projectDemo1.Entity.patientVO;
import com.projectDemo1.Response.ResponseHandle;
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
	public ResponseHandle insertPatientDetails(patientVO vo) throws patientException {
		Long flag = patientBO.insertPatientDetails(vo);
		if (flag > 0) {
			response.setSucessmessage("patient Details added successfully");
			response.setId(flag);
		} else {
			throw new patientException("Error in inserting patient");
		}
		return response;
	}

	// find by Id method:
	@Transactional
	public ResponseHandle fetchById(long id) throws patientException {
		patientVO ret = patientBO.fetchByID(id);
		if (ret == null) {
			throw new patientException("There are no patient in the given ID");
		}
		response.setSucessmessage("patient Details fetched successfully");
		response.setPatient(ret);
		return response;
	}

	// fetch all method:
	@Transactional
	public ResponseHandle fetchAll() {
		response.setListpatient(patientBO.fetchAll());
		return response;
	}

	// update method
	@Transactional
	public ResponseHandle updatePatientDetails(long id) throws patientException {
		boolean flag = patientBO.updatePatientDetails(id);
		if (flag) {
			response.setSucessmessage("updated the patient details successfully");
		} else {
			throw new patientException("error in updating patient details");
		}

		return response;
	}

	// Associate method:
	@Transactional
	public ResponseHandle associate(patientVO vo) {
		patientVO inserted = patientBO.Associate(vo);
		long id = inserted.getPatientId();

		if (id > 0) {
			response.setSucessmessage("added successfully");
			response.setId(id);
		} else {
			response.setFailuremessage("Failed to add data");
		}

		return response;
	}

	// find by patient phone number:
	@Transactional
	public ResponseHandle findbyphone(String ph) {
		patientVO vo = patientBO.fetchbyPhoneNumber(ph);
		response.setPatient(vo);
		return response;

	}

	// fetch by day appointments:
	public ResponseHandle findapptDay(LocalDate td) {
		List<patientVO> vo = patientBO.fetchapptDay(td);
		response.setListpatient(vo);
		return response;
	}

}
