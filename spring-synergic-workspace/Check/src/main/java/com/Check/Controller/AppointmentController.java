package com.Check.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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

import com.Check.CustomExceptions.AppointmentException;
import com.Check.CustomExceptions.DateException;
import com.Check.CustomExceptions.DateOfBirthException;
import com.Check.CustomExceptions.EmailException;
import com.Check.CustomExceptions.IdException;
import com.Check.CustomExceptions.PasswordException;
import com.Check.CustomExceptions.PatientException;
import com.Check.CustomExceptions.PhoneNumberException;
import com.Check.DTO.AppointmentDTO;
import com.Check.DTO.AppointmentPatientDTO;
import com.Check.Entity.AppointmentsVO;
import com.Check.Entity.PatientVO;
import com.Check.Response.ResponseHandle;
import com.Check.Response.ResponseHandleAppointments;
import com.Check.Service.AppointmentsService;
import com.Check.Service.PatientService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentsService aser;

	@Autowired
	private PatientService pser;

	@Autowired
	private ResponseHandleAppointments apptRes;

	@Autowired
	private ResponseHandle patRes;

	Logger log = Logger.getLogger(AppointmentController.class);

	// insert:
	@PostMapping("/insert")
	public ResponseEntity<?> insertAppointment(@RequestBody AppointmentPatientDTO dto) {
		log.info("Appointment booking with patient details method triggered in controller layer...");

		// converting DTO to entity
		AppointmentsVO vo = new AppointmentsVO();
		vo.setAppointmentDate(dto.getAppointment().getAppointmentDate());
		vo.setDoctor(dto.getAppointment().getDoctor());
		vo.setReason(dto.getAppointment().getReason());

		PatientVO vo1 = new PatientVO();
		vo1.setFirstName(dto.getPatient().getFirstName());
		vo1.setLastName(dto.getPatient().getLastName());
		vo1.setPatientEmail(dto.getPatient().getPatientEmail());
		vo1.setPatientPassword(dto.getPatient().getPatientPassword());
		vo1.setPatientPhone(dto.getPatient().getPatientPhone());
		vo1.setDob(dto.getPatient().getDob());

		try {
			patRes = pser.insertPatientDetails(vo1);
		} catch (PatientException e) {
			log.error("Patient Details details records not in the format", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (PhoneNumberException e) {
			log.error("Phone number format is wrong", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (EmailException e) {
			log.error("email format is not valid", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (PasswordException e) {
			log.error("password format is not valid", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (DateOfBirthException e) {
			log.error("Date of Birth format is not in the pattern", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		vo.setPatient(patRes.getPatient());
		log.info("Assigned Patient to Appointment VO.");

		try {
			log.info("Attempting to insert appointment details...");
			apptRes = aser.insertAppointments(vo);
			dto.getAppointment().setAppointmentID(vo.getAppointmentID());
			dto.getAppointment().setCreatedAt(vo.getCreatedAt());
			dto.getAppointment().setUpdatedAt(vo.getUpdatedAt());
			return ResponseEntity
					.ok("Appointments Details successfully saved: " + apptRes.getAppoVo().getAppointmentID());
		} catch (IdException e) {
			log.error("Appointment ID is not present in the DataBase", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (EmailException e) {
			log.error("email format is not valid", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (PasswordException e) {
			log.error("password format is not valid", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (PhoneNumberException e) {
			log.error("Date of Birth format is not in the pattern", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (AppointmentException e) {
			log.error("Appointment exception caught", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	// insert appointments with patient ID
	@PostMapping("/insertWithPatientID")
	public ResponseEntity<?> insertAppointmentsWithPatientID(@RequestBody AppointmentPatientDTO dto) {
		log.info("Appointment booking with patient ID method triggered in controller layer...");

		// converting DTO to entity
		AppointmentsVO vo = new AppointmentsVO();
		vo.setAppointmentDate(dto.getAppointment().getAppointmentDate());
		vo.setDoctor(dto.getAppointment().getDoctor());
		vo.setReason(dto.getAppointment().getReason());

		PatientVO vo1 = new PatientVO();
		vo1.setPatientId(dto.getPatient().getPatientId());
		vo.setPatient(vo1);

		log.info("Assigned Patient ID to Appointment VO");

		try {
			log.info("Attempting to insert appointment details with existing patient ID...");
			apptRes = aser.insertAppointmentsWithPatientID(vo);
			dto.getAppointment().setAppointmentID(vo.getAppointmentID());
			dto.getAppointment().setCreatedAt(vo.getCreatedAt());
			dto.getAppointment().setUpdatedAt(vo.getUpdatedAt());
			return ResponseEntity
					.ok("Appointments Details successfully saved: " + apptRes.getAppoVo().getAppointmentID());
		} catch (IdException e) {
			log.error("Appointment ID is not present in the DataBase", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (EmailException e) {
			log.error("email format is not valid", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (PasswordException e) {
			log.error("password format is not valid", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (PhoneNumberException e) {
			log.error("Date of Birth format is not in the pattern", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (AppointmentException e) {
			log.error("Appointment exception caught", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	// fetch by ID:
	@GetMapping("appointmentID/{id}")
	public ResponseEntity<?> findByappointmentId(@PathVariable("id") long id) {
		log.info("appointment details by their ID...");
		try {
			log.info("Fetching appointment details by ID: " + id);
			apptRes = aser.fetchByID(id);
			return ResponseEntity.ok("Appointment Details Fetched by ID:" + apptRes.getAppoVo());
		} catch (IdException e) {
			log.error("ID not found in the DateBase", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	// fetch all:
	@GetMapping("/fetchallAppointments")
	public List<AppointmentDTO> fetchall() {
		log.info("appointment chooses fetch all the details option...");
		apptRes = aser.fetchAll();
		List<AppointmentsVO> list = apptRes.getList();
		List<AppointmentDTO> listd = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			AppointmentsVO vo = list.get(i);
			AppointmentDTO getDto = mapToDTO(vo);
			listd.add(getDto);
		}
		log.info("All appointment details fetched successfully.");
		return listd;

	}

	// update method:
	@PutMapping("/updateAppointments/{id}")
	public ResponseEntity<?> updateAppointmentDetails(@PathVariable long id) {
		log.info("Appointment details update method triggerred");

		try {
			apptRes = aser.update(id);
			log.info("Appointment ID: " + apptRes.getAppoVo().getAppointmentID() + " updated successfully.");
			return ResponseEntity.ok("Appointment ID: " + apptRes.getAppoVo().getAppointmentID() + " updated");
		} catch (IdException e) {
			log.error("ID not found in the DataBase", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	// Appointment by between two days:
	@GetMapping("/AppointmentDetailsAmongTwoDate/{sd}/{ld}")
	public ResponseEntity<?> betweenTwoDOBpat(@PathVariable("sd") LocalDate sd, @PathVariable("ld") LocalDate ld) {
		log.info("Appointment details with the two dates...");
		try {
			log.info("Fetching between start date: " + sd + " and end date: " + ld);
			apptRes = aser.fetchApptBetweenTwoDates(sd, ld);
			List<AppointmentsVO> list = apptRes.getList();
			List<AppointmentDTO> listd = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				AppointmentsVO vo = list.get(i);
				AppointmentDTO getDto = mapToDTO(vo);
				listd.add(getDto);
				log.info("Fetched appointment details between two dates successfully.");
			}
		} catch (DateException e) {
			log.error("Id Exception", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		return ResponseEntity.ok("Appointment detials fetched successfully" + apptRes.getList());

	}

	// ascending order:
	@GetMapping("/AppointmentAscendingOrder")
	public ResponseEntity<?> acending() {
		log.info("Appointments fetching all the details in ascending order...");
		try {
			apptRes = aser.acending();
			List<AppointmentsVO> list = apptRes.getList();
			List<AppointmentDTO> listd = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				AppointmentsVO vo = list.get(i);
				AppointmentDTO getDto = mapToDTO(vo);
				listd.add(getDto);
			}
		} catch (AppointmentException e) {
			log.error("Id Exception", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		return ResponseEntity.ok("Ascending order detials fetched successfully" + apptRes.getList());

	}

	// Vo to DTO method
	public static AppointmentDTO mapToDTO(AppointmentsVO vo) {
		AppointmentDTO dto = new AppointmentDTO();
		dto.setAppointmentDate(vo.getAppointmentDate());
		dto.setAppointmentID(vo.getAppointmentID());
		dto.setDoctor(vo.getDoctor());
//		dto.setPatient(vo.getPatient());
		dto.setReason(vo.getReason());
		dto.setCreatedAt(vo.getCreatedAt());
		dto.setUpdatedAt(vo.getUpdatedAt());

		return dto;
	}

}
