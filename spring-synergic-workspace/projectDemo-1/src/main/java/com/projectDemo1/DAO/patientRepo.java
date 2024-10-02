package com.projectDemo1.DAO;

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

}
