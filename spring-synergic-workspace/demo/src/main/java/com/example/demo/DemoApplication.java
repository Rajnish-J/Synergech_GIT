package com.example.demo;

import com.example.demoBO.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demoBO.IndiaBO;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hi this is the first output from Spring project");
		
		IndiaBO bo = ctx.getBean(IndiaBO.class);
		bo.display();
		
	}

}
