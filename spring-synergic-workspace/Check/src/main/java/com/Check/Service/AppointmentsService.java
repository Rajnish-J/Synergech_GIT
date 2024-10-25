package com.Check.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Check.BO.AppointmentsBO;
import com.Check.CustomExceptions.AppointmentException;
import com.Check.CustomExceptions.DateException;
import com.Check.CustomExceptions.EmailException;
import com.Check.CustomExceptions.IdException;
import com.Check.CustomExceptions.PasswordException;
import com.Check.CustomExceptions.PhoneNumberException;
import com.Check.Entity.AppointmentsVO;
import com.Check.Response.ResponseHandleAppointments;

import jakarta.transaction.Transactional;

@Service
public class AppointmentsService {

	@Autowired
	AppointmentsBO apptBO;

	@Autowired
	ResponseHandleAppointments apptsRes;

	// Insert method:
	@Transactional
	public ResponseHandleAppointments insertAppointments(AppointmentsVO vo)
			throws IdException, EmailException, PasswordException, PhoneNumberException, AppointmentException {
		AppointmentsVO flag = apptBO.insertAppointments(vo);
		if (flag != null) {
			apptsRes.setSucessMessage("Appointments added successfully");
			apptsRes.setAppoVo(vo);
		} else {
			apptsRes.setFailureMessage("Error in inserting appointment details");
		}
		return apptsRes;
	}

	@Transactional
	public ResponseHandleAppointments insertAppointmentsWithPatientID(AppointmentsVO vo)
			throws IdException, EmailException, PasswordException, PhoneNumberException, AppointmentException {
		AppointmentsVO flag = apptBO.insertAppointmentsWithPatientID(vo);
		if (flag != null) {
			apptsRes.setSucessMessage("Appointments added successfully");
			apptsRes.setAppoVo(vo);
		} else {
			apptsRes.setFailureMessage("Error in inserting appointment details");
		}
		return apptsRes;
	}

	// fetchByID method:
	@Transactional
	public ResponseHandleAppointments fetchByID(Long id) throws IdException {
		AppointmentsVO vo = apptBO.fetchByID(id);
		if (vo != null) {
			apptsRes.setSucessMessage("Appointments fetched successfully");
			apptsRes.setAppoVo(vo);
		} else {
			apptsRes.setFailureMessage("Error in fetching appointment details");
		}
		return apptsRes;
	}

	// fetchAll method:
	@Transactional
	public ResponseHandleAppointments fetchAll() {
		List<AppointmentsVO> list = apptBO.fetchAll();
		if (list.size() > 0) {
			apptsRes.setSucessMessage("all the appointments fetched successfully");
			apptsRes.setList(list);
		} else {
			apptsRes.setFailureMessage("Error in fetching appointment records");
		}
		return apptsRes;
	}

	// update method:
	@Transactional
	public ResponseHandleAppointments update(Long id) throws IdException {
		AppointmentsVO vo = apptBO.updateAppointmentDetails(id);
		if (vo != null) {
			apptsRes.setSucessMessage("Appointment updated succuessfully");
			apptsRes.setAppoVo(vo);
		} else {
			apptsRes.setFailureMessage("Error in updating appointment details");
		}
		return apptsRes;
	}

	// fetching appt details between two dates
	@Transactional
	public ResponseHandleAppointments fetchApptBetweenTwoDates(LocalDate sd, LocalDate ld) throws DateException {
		List<AppointmentsVO> list = apptBO.fetchApptBetweenTwoDates(sd, ld);
		if (list.size() > 0) {
			apptsRes.setSucessMessage("all the appointments fetched");
			apptsRes.setList(list);
		} else {
			apptsRes.setFailureMessage("Error in fetching");
		}
		return apptsRes;
	}

	// ascending order:
	public ResponseHandleAppointments acending() throws AppointmentException {
		List<AppointmentsVO> list = apptBO.ascending();
		if (list.size() > 0) {
			apptsRes.setList(list);
			apptsRes.setSucessMessage("fetching the paitent details in ascending order is successfully executed");
		} else {
			apptsRes.setFailureMessage("Error in fetching...");
		}
		return apptsRes;
	}
}
