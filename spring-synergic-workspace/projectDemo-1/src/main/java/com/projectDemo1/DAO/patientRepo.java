package com.projectDemo1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectDemo1.Entity.patientVO;

@Repository
public interface patientRepo extends JpaRepository<patientVO, Long> {

}
