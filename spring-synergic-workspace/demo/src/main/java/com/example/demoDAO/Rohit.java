package com.example.demoDAO;	

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Rohit implements I_IndianTeam{

	@Override
	public void ODIHundreds() {
		System.out.println("28 international ODI centuries");
	}

}
