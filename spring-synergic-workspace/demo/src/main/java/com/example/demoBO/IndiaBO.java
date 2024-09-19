package com.example.demoBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demoDAO.I_IndianTeam;

public class IndiaBO {
	
	@Autowired
	@Qualifier("abc")
	I_IndianTeam i1 = null;
}
