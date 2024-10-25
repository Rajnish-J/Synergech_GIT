package com.Check.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Check.Repo.HospitalRepo;

@Component
public class HospitalBO {

	@Autowired
	HospitalRepo hospitalRepo;
}
