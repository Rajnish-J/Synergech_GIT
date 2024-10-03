package com.projectDemo1.DAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projectDemo1.Entity.patientVO;

@Repository
public interface patientRepo extends JpaRepository<patientVO, Long> {

	// fetch by phone number
	@Query("SELECT p FROM patientVO p WHERE p.PatientPhone = :phone")
	patientVO findByPhoneNumber(@Param("phone") String phone);

	// fetching patient who all are having appointments today:
	@Query("SELECT p FROM patientVO p JOIN p.appointments a WHERE a.appointmentDate = :today")
	List<patientVO> findPatientsWithAppointmentsDay(@Param("today") LocalDate today);

	// fetch appointments of the patient who all are having more than given number
	// by the user:
	@Query("SELECT p FROM patientVO p WHERE (SELECT COUNT(a) FROM appointmentsVO a WHERE a.patient.patientId = p.patientId) > :appointmentCount")
	List<patientVO> findPatientsWithMoreThanNAppointments(@Param("appointmentCount") Long appointmentCount);

	// fetching the last name and first name of the patient with patient ID using
	// projection interfaceL
	@Query("SELECT p.patientId AS patientId, p.firstName AS firstName, p.lastName AS lastName "
			+ "FROM patientVO p WHERE p.patientId = :patientId")
	PatientProjection findNameOfPatientById(@Param("patientId") Long patientId);

	// fetching all the patients details who all are having DOB between given two
	// numbers:
	@Query(name = "appointmentsVO.findByDOBRange")
	List<patientVO> fetchBetweenDOBpat(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

	// fetching all the patient details in ascending order;
	@Query(name = "patientVO.findAllOrderedByAttendance")
	List<patientVO> fetchAscending();

	@Query("SELECT p.patientId AS patientId FROM patientVO p ")
	List<Long> fetchPatientId();

}
