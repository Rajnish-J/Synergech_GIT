package com.projectDemo1.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectDemo1.DTO.patientDTO;
import com.projectDemo1.Entity.patientVO;
import com.projectDemo1.Response.ResponseHandle;
import com.projectDemo1.Service.patientService;

@RestController
@RequestMapping("/patient")
public class patientController {

	@Autowired
	private patientService pservice;

	@Autowired
	private ResponseHandle res;

	// need to check
	// insert:
	@PostMapping("/insert")
	public patientVO insertPatient(@RequestBody patientDTO dto) {

		// converting DTO to entity
		patientVO vo = new patientVO();
		vo.setFirstName(dto.getFirstName());
		vo.setLastName(dto.getLastName());
		vo.setPatientEmail(dto.getPatientEmail());
		vo.setPatientPassword(dto.getPatientPassword());
		vo.setPatientPhone(dto.getPatientPhone());
		vo.setDob(dto.getDob());

		res = pservice.insertPatientDetails(vo);
		patientVO inserted = res.getPatient();
		dto.setUpdatedAt(inserted.getUpdatedAt());
		dto.setCreatedAt(inserted.getCreatedAt());
		dto.setPatientId(inserted.getPatientId());
		return inserted;

	}

	// done
	// fetch by id:
	@GetMapping("patientId/{id}")
	public patientDTO findBypatientId(@PathVariable("id") long id) {
		res = pservice.fetchById(id);
		return mapToDTO(res.getPatient());
	}

	// done
	// fetch all:
	@GetMapping("/fetchallPatient")
	public List<patientDTO> fetchall() {
		res = pservice.fetchAll();
		List<patientVO> list = res.getListpatient();
		List<patientDTO> listd = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			patientVO vo = list.get(i);
			patientDTO getDto = mapToDTO(vo);
			listd.add(getDto);
		}

		return listd;

	}

	// need to check
	// update method
	@PutMapping("update/{id}")
	public patientDTO fetchpatientDetails(@RequestBody long id) {
		res = pservice.updatePatientDetails(id);
		return mapToDTO(res.getPatient());
	}

	// done
	// find by patient phone number:
	@GetMapping("/fetchByPhoneNumber/{ph}")
	public patientDTO findbyphone(@PathVariable("ph") String ph) {
		res = pservice.findbyphone(ph);
		return mapToDTO(res.getPatient());
	}

	// done
	// fetch by day appointments:
	@GetMapping("/appointmentDate/{td}")
	public List<patientDTO> findapptDay(@PathVariable("td") LocalDate td) {
		res = pservice.findapptDay(td);
		List<patientVO> list = res.getListpatient();
		List<patientDTO> listd = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			patientVO vo = list.get(i);
			patientDTO getDto = mapToDTO(vo);
			listd.add(getDto);
		}

		return listd;
	}

	// done
	// fetch by more appointments
	@GetMapping("/findAppointmentsById/{id}")
	public List<patientDTO> findAppointmentsByNumber(@PathVariable("id") long n) {
		res = pservice.findAppointmentsByNumber(n);
		List<patientVO> list = res.getListpatient();
		List<patientDTO> listd = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			patientVO vo = list.get(i);
			patientDTO getDto = mapToDTO(vo);
			listd.add(getDto);
		}

		return listd;
	}

	// done
	// fetch first name and last name:
	@GetMapping("/findFirstandLastNamebyPatientId/{id}")
	public String findName(@PathVariable("id") long n) {
		res = pservice.findName(n);
		return "First name: " + res.getPro().getFirstName() + " Second name: " + res.getPro().getLastName();
	}

	// done
	// Appointment by between two days:
	@GetMapping("/patientDetailsAmongTwoDetails/{sd}/{ld}")
	public List<patientDTO> betweenTwoDOBpat(@PathVariable("sd") LocalDate sd, @PathVariable("ld") LocalDate ld) {
		res = pservice.betweenTwoDOBpat(sd, ld);
		List<patientVO> list = res.getListpatient();
		List<patientDTO> listd = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			patientVO vo = list.get(i);
			patientDTO getDto = mapToDTO(vo);
			listd.add(getDto);
		}

		return listd;

	}

	// done
	// ascending order:
	@GetMapping("/AscendingOrder")
	public List<patientDTO> acending() {
		res = pservice.acending();
		List<patientVO> list = res.getListpatient();
		List<patientDTO> listd = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			patientVO vo = list.get(i);
			patientDTO getDto = mapToDTO(vo);
			listd.add(getDto);
		}

		return listd;

	}

	// own method => converts entity to DTO:
	public static patientDTO mapToDTO(patientVO vo) {

		patientDTO dto = new patientDTO();
		dto.setFirstName(vo.getFirstName());
		dto.setLastName(vo.getLastName());
		dto.setPatientEmail(vo.getPatientEmail());
		dto.setPatientPassword(vo.getPatientPassword());
		dto.setPatientPhone(vo.getPatientPhone());
		dto.setDob(vo.getDob());
		dto.setUpdatedAt(vo.getUpdatedAt());
		dto.setCreatedAt(vo.getCreatedAt());
		dto.setPatientId(vo.getPatientId());

		return dto;

	}
}
