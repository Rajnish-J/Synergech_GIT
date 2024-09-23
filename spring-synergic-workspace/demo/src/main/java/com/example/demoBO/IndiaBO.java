package com.example.demoBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demoDAO.I_IndianTeam;

@Component
public class IndiaBO {

	@Autowired
	I_IndianTeam i1;
	
	public void display() {
		i1.ODIHundreds();
	}

	public I_IndianTeam getI1() {
		return i1;
	}

	public void setI1(I_IndianTeam i1) {
		this.i1 = i1;
	}

}
