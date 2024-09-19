package com.example.demoDAO;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Rohit implements I_IndianTeam{

	public void ODIHundreds() {
		System.out.println("28 international ODI centuries");
	}

}
