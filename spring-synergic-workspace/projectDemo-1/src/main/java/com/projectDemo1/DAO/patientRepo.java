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

	@Query("SELECT p FROM patientVO p WHERE (SELECT COUNT(a) FROM appointmentsVO a WHERE a.patient.patientId = p.patientId) > :appointmentCount")
	List<patientVO> findPatientsWithMoreThanNAppointments(@Param("appointmentCount") Long appointmentCount);

	@Query("SELECT p.patientId AS patientId, p.firstName AS firstName, p.lastName AS lastName "
			+ "FROM patientVO p WHERE p.patientId = :patientId")
	PatientProjection findNameOfPatientById(@Param("patientId") Long patientId);

}
