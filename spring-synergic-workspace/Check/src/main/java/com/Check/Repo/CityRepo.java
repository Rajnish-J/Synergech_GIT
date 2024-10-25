package com.Check.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Check.Entity.CityVO;

@Repository
public interface CityRepo extends JpaRepository<CityVO, Integer> {

}
