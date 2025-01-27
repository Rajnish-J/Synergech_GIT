package JDBC_assn;

import java.sql.Date;

public class StudentVO {
	private int id;
	private String name;
	private Date dob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

}
