package com.Check.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Check.Entity.CountryVO;

@Repository
public interface CountryRepo extends JpaRepository<CountryVO, Integer> {

}
