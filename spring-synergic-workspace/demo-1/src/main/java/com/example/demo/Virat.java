package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Virat implements IndiaTeam {

	@Override
	public void ODIHundreds() {
		System.out.println(" 50 one day international centuries");
	}
	
}
