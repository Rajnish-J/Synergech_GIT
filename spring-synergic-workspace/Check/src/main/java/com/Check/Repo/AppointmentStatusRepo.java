package com.Check.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Check.Entity.AppointmentStatusVO;

@Repository
public interface AppointmentStatusRepo extends JpaRepository<AppointmentStatusVO, Integer> {

}
