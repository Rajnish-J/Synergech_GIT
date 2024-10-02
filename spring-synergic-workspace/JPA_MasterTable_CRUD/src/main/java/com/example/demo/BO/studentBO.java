package com.example.demo.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.student;
import com.example.demo.repo.studentRepo;

@Service
public class studentBO {

	@Autowired
	studentRepo stud;

	public void insertStudent(student s) {
		stud.save(s);
	}

}
