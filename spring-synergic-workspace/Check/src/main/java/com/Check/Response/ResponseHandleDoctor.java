package com.Check.Response;

import org.springframework.stereotype.Component;

import com.Check.Entity.DoctorVO;

@Component
public class ResponseHandleDoctor {

	private String sucessMessage;
	private String failureMessage;
	private long id;
	private DoctorVO docVo;

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

	public DoctorVO getDocVo() {
		return docVo;
	}

	public void setDocVo(DoctorVO docVo) {
		this.docVo = docVo;
	}

}
