package com.example.demoDAO;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class Virat implements I_IndianTeam{

	public void ODIHundreds() {
		System.out.println("50 Internationl ODI Centuries....");
	}
	
}
