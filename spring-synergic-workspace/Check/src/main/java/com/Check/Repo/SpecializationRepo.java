package com.Check.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Check.Entity.SpecializationVO;

@Repository
public interface SpecializationRepo extends JpaRepository<SpecializationVO, Integer> {

}
