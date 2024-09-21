package com.example.demoBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demoDAO.I_IndianTeam;

public class IndiaBO {

	@Autowired
//	@Qualifier("abc")
	I_IndianTeam i1 = null;

	public I_IndianTeam getI1() {
		return i1;
	}

	public void setI1(I_IndianTeam i1) {
		this.i1 = i1;
	}

	public void print() {
		i1.ODIHundreds();
	}
}
