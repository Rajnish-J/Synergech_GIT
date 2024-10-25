package com.Check.Response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Check.Entity.AppointmentsVO;
import com.Check.Entity.DoctorVO;
import com.Check.Repo.DoctorDetailsProjection;

@Component
public class ResponseHandleAppointments {
	private String sucessMessage;
	private String failureMessage;
	private long id;
	private AppointmentsVO appoVo;
	private List<AppointmentsVO> list;
	private List<DoctorVO> listDoctorDetails;
	private List<DoctorDetailsProjection> listSpecialiaztion;

	public String getSucessMessage() {
		return sucessMessage;
	}

	public void setSucessMessage(String sucessMessage) {
		this.sucessMessage = sucessMessage;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AppointmentsVO getAppoVo() {
		return appoVo;
	}

	public void setAppoVo(AppointmentsVO appoVo) {
		this.appoVo = appoVo;
	}

	public List<AppointmentsVO> getList() {
		return list;
	}

	public void setList(List<AppointmentsVO> list) {
		this.list = list;
	}

	public List<DoctorVO> getListDoctorDetails() {
		return listDoctorDetails;
	}

	public void setListDoctorDetails(List<DoctorVO> listDoctorDetails) {
		this.listDoctorDetails = listDoctorDetails;
	}

	public List<DoctorDetailsProjection> getListSpecialiaztion() {
		return listSpecialiaztion;
	}

	public void setListSpecialiaztion(List<DoctorDetailsProjection> listSpecialiaztion) {
		this.listSpecialiaztion = listSpecialiaztion;
	}

}
