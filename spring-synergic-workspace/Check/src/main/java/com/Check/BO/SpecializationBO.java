package com.Check.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Check.Repo.SpecializationRepo;

@Component
public class SpecializationBO {

	@Autowired
	SpecializationRepo specializationRepo;
}
