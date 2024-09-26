package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IndiaBO {
	
	@Autowired
//	@Qualifier("rohit")
	private IndiaTeam india;	
	
	public void print() {
		india.ODIHundreds();
	}
}
