package com.Check.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Check.CustomExceptions.AppointmentBookingDateException;
import com.Check.CustomExceptions.AppointmentException;
import com.Check.CustomExceptions.DateException;
import com.Check.CustomExceptions.DateOfBirthException;
import com.Check.CustomExceptions.EmailException;
import com.Check.CustomExceptions.IdException;
import com.Check.CustomExceptions.PasswordException;
import com.Check.CustomExceptions.PatientException;
import com.Check.CustomExceptions.PhoneNumberException;
import com.Check.DTO.AppointmentDTO;
import com.Check.DTO.PatientDTO;
import com.Check.Entity.AppointmentsVO;
import com.Check.Entity.PatientVO;
import com.Check.Response.ResponseHandle;
import com.Check.Service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService pservice;

	@Autowired
	private ResponseHandle res;

	// insert:
	@PostMapping("/insert")
	public ResponseEntity<?> insertPatient(@RequestBody PatientDTO dto) {

		// converting DTO to entity
		PatientVO vo = new PatientVO();
		vo.setFirstName(dto.getFirstName());
		vo.setLastName(dto.getLastName());
		vo.setPatientEmail(dto.getPatientEmail());
		vo.setPatientPassword(dto.getPatientPassword());
		vo.setPatientPhone(dto.getPatientPhone());
		vo.setDob(dto.getDob());

		try {
			res = pservice.insertPatientDetails(vo);
			dto.setUpdatedAt(res.getPatient().getUpdatedAt());
			dto.setCreatedAt(res.getPatient().getCreatedAt());
			dto.setPatientId(res.getPatient().getPatientId());
			return ResponseEntity.ok("Patient Details successfully saved: " + res.getPatient().getPatientId());
		} catch (PatientException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (PhoneNumberException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (EmailException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (PasswordException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (DateOfBirthException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	// fetch by id:
	@GetMapping("patientId/{id}")
	public ResponseEntity<?> findBypatientId(@PathVariable("id") long id) {
		try {
			res = pservice.fetchById(id);
			return ResponseEntity.ok("Patient Details Fetched by ID:" + res.getPatient());
		} catch (IdException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	// fetch all:
	@GetMapping("/fetchallPatient")
	public List<PatientDTO> fetchall() {
		res = pservice.fetchAll();
		List<PatientVO> list = res.getListPatient();
		List<PatientDTO> listd = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			PatientVO vo = list.get(i);
			PatientDTO getDto = mapToDTO(vo);
			listd.add(getDto);
		}
		return listd;
	}

	// update method
	@PutMapping("/update/{id}")
	public ResponseEntity<?> fetchpatientDetails(@PathVariable long id) {
		try {
			res = pservice.updatePatientDetails(id);
			return ResponseEntity.ok(mapToDTO(res.getPatient()));
		} catch (IdException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	// association method
	@PostMapping("/associatePatientsWithAppointments")
	public ResponseEntity<?> associate(@RequestBody PatientDTO dto) {

		// Create PatientVO object
		PatientVO vo = new PatientVO();
		vo.setFirstName(dto.getFirstName());
		vo.setLastName(dto.getLastName());
		vo.setPatientEmail(dto.getPatientEmail());
		vo.setPatientPassword(dto.getPatientPassword());
		vo.setPatientPhone(dto.getPatientPhone());
		vo.setDob(dto.getDob());

		List<AppointmentDTO> list = dto.getAppointments();
		List<AppointmentsVO> listvo = new ArrayList<>();
		for (AppointmentDTO obj : dto.getAppointments()) {
			AppointmentsVO avo = new AppointmentsVO();
			avo.setAppointmentDate(obj.getAppointmentDate());
			avo.setReason(obj.getReason());
			avo.setDoctor(obj.getDoctor());
			avo.setPatient(vo);
			listvo.add(avo);
		}
		vo.setAppointments(listvo);

		try {
			res = pservice.associate(vo);
			return ResponseEntity.ok("Patient Details and Appointments added successfully. Patient ID: "
					+ res.getPatient().getPatientId());

		} catch (PatientException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		} catch (PhoneNumberException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		} catch (EmailException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		} catch (PasswordException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		} catch (AppointmentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		} catch (AppointmentBookingDateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		} catch (DateOfBirthException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	// find by patient phone number:
	@GetMapping("/fetchByPhoneNumber/{ph}")
	public ResponseEntity<?> findbyphone(@PathVariable("ph") String ph) {
		try {
			res = pservice.findbyphone(ph);
			return ResponseEntity.ok("Patient Details Fetched by ID:" + res.getPatient());
		} catch (PhoneNumberException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	// fetch by day appointments:
	@GetMapping("/appointmentDate/{td}")
	public ResponseEntity<?> findapptDay(@PathVariable("td") LocalDate td) {
		try {
			res = pservice.findapptDay(td);
		} catch (AppointmentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		List<PatientVO> list = res.getListPatient();
		List<PatientDTO> listd = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			PatientVO vo = list.get(i);
			PatientDTO getDto = mapToDTO(vo);
			listd.add(getDto);
		}

		return ResponseEntity.ok(listd);
	}

	// fetch first name and last name:
	@GetMapping("/findFirstandLastNamebyPatientId/{id}")
	public ResponseEntity<?> findName(@PathVariable("id") long n) {
		try {
			res = pservice.findName(n);
			return ResponseEntity
					.ok("First name: " + res.getPro().getFirstName() + " Second name: " + res.getPro().getLastName());
		} catch (IdException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	// patient details by between two days:
	@GetMapping("/patientDetailsAmongTwoDate/{sd}/{ld}")
	public ResponseEntity<?> betweenTwoDOBpat(@PathVariable("sd") LocalDate sd, @PathVariable("ld") LocalDate ld) {
		try {
			res = pservice.betweenTwoDOBpat(sd, ld);
			List<PatientVO> list = res.getListPatient();
			List<PatientDTO> listd = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				PatientVO vo = list.get(i);
				PatientDTO getDto = mapToDTO(vo);
				listd.add(getDto);
			}
		} catch (DateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		return ResponseEntity.ok("Patient detials fetched successfully" + res.getListPatient());

	}

	// ascending order:
	@GetMapping("/AscendingOrder")
	public ResponseEntity<?> acending() {
		try {
			res = pservice.ascending();
			List<PatientVO> list = res.getListPatient();
			List<PatientDTO> listd = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				PatientVO vo = list.get(i);
				PatientDTO getDto = mapToDTO(vo);
				listd.add(getDto);
			}
		} catch (AppointmentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		return ResponseEntity.ok("Ascending order detials fetched successfully" + res.getListPatient());

	}

	// own method => converts entity to DTO:
	public static PatientDTO mapToDTO(PatientVO vo) {

		PatientDTO dto = new PatientDTO();
		dto.setFirstName(vo.getFirstName());
		dto.setLastName(vo.getLastName());
		dto.setDob(vo.getDob());
		dto.setPatientEmail(vo.getPatientEmail());
		dto.setPatientPhone(vo.getPatientPhone());
		dto.setPatientPassword(vo.getPatientPassword());
		dto.setCreatedAt(vo.getCreatedAt());
		dto.setUpdatedAt(vo.getUpdatedAt());

		List<AppointmentsVO> list = vo.getAppointments();
		List<AppointmentDTO> dtoList = new ArrayList<>();
		for (AppointmentsVO ob : list) {
			AppointmentDTO apdto = new AppointmentDTO();
			apdto.setAppointmentDate(ob.getAppointmentDate());
			apdto.setReason(ob.getReason());
			apdto.setDoctor(ob.getDoctor());
			dtoList.add(apdto);
		}
		dto.setAppointments(dtoList);
		return dto;
	}
}
