package com.Check.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Check.Entity.HospitalVO;

@Repository
public interface HospitalRepo extends JpaRepository<HospitalVO, Long> {

}
