package com.Check.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Check.BO.DoctorBO;
import com.Check.CustomExceptions.IdException;
import com.Check.Entity.DoctorVO;
import com.Check.Repo.DoctorDetailsProjection;
import com.Check.Response.ResponseHandleAppointments;
import com.Check.Response.ResponseHandleDoctor;

@Service
public class DoctorService {
	@Autowired
	DoctorBO doctorBO;

	@Autowired
	ResponseHandleAppointments apptsRes;

	@Autowired
	ResponseHandleDoctor docRes;

	public ResponseHandleAppointments fetch() {
		List<DoctorDetailsProjection> list = doctorBO.fetch();
		if (list.size() > 0) {
			apptsRes.setSucessMessage("All doctor's fetched with specilization");
			apptsRes.setListSpecialiaztion(list);

		} else {
			apptsRes.setFailureMessage("error in fetching");
		}

		return apptsRes;
	}

	public ResponseHandleDoctor insertDoctorWithAppointment(DoctorVO vo) throws IdException {
		DoctorVO flag = doctorBO.insertDoctorWithAppointment(vo);
		if (flag != null) {
			docRes.setSucessMessage("Doctor fetched successfully");
			docRes.setDocVo(flag);
		} else {
			docRes.setFailureMessage("Error in fetching doctor object");
		}
		return docRes;
	}
}
