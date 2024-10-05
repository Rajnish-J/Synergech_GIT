package com.EntityBeanSeminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EntityBeanSeminarApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EntityBeanSeminarApplication.class, args);
		System.out.println("Welcome to Entity Bean seminar and its corresponding annotations....");
	}

}
