package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.BO.studentBO;
import com.example.demo.DAO.student;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = { "com.example.demo.DAO" })
public class JpaMasterTableCrudApplication {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JpaMasterTableCrudApplication.class, args);
		System.out.println("Check");

		student s = new student();
		studentBO sbo = ctx.getBean(studentBO.class);
		System.out.print("Enter Student ID: ");
		s.setS_id(sc.nextInt());
		System.out.print("Enter Student name: ");
		s.setName(sc.next());
		System.out.print("Enter Student age: ");
		s.setAge(sc.nextInt());
		System.out.print("Enter Student mark: ");
		s.setMarks(sc.nextDouble());

		sbo.insertStudent(s);

	}

}
