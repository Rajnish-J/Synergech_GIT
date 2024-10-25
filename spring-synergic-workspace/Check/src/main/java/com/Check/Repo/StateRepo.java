package com.Check.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Check.Entity.StateVO;

@Repository
public interface StateRepo extends JpaRepository<StateVO, Integer> {

}
