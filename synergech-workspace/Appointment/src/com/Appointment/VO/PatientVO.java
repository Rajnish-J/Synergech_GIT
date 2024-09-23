package com.Appointment.VO;

public class PatientVO {
	private int patientId;
	private String fName;
	private String lName;
	private String dob;
	private String p_phone;
	private String p_email;
	private String p_password;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getP_phone() {
		return p_phone;
	}

	public void setP_phone(String p_phone) {
		this.p_phone = p_phone;
	}

	public String getP_email() {
		return p_email;
	}

	public void setP_email(String p_email) {
		this.p_email = p_email;
	}

	public String getP_password() {
		return p_password;
	}

	public void setP_password(String p_password) {
		this.p_password = p_password;
	}

	@Override
	public String toString() {
		return "[patientId=" + patientId + ", First Name=" + fName + ", Last Name=" + lName + ", Date Of Birth=" + dob
				+ ", phone number=" + p_phone + ", email ID=" + p_email + ", password=" + p_password + "]";
	}

}
