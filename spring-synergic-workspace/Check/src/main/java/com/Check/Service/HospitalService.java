package com.Check.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Check.BO.HospitalBO;

@Service
public class HospitalService {
	@Autowired
	HospitalBO hospitalBO;
}
