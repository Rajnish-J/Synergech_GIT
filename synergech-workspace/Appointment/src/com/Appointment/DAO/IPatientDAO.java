package com.Appointment.DAO;

import java.sql.SQLException;
import java.util.List;

import com.Appointment.VO.PatientVO;
import com.Appointment.customExceptions.PatientNotFoundException;
import com.Appointment.customExceptions.UpdateException;

public interface IPatientDAO {
	boolean savePatientDetails(PatientVO vo) throws SQLException, PatientNotFoundException;

	PatientVO fetchById(int id) throws SQLException;

	List<PatientVO> fetchAllPatient() throws SQLException;

	boolean updatePatientDetails() throws SQLException, UpdateException;
}
