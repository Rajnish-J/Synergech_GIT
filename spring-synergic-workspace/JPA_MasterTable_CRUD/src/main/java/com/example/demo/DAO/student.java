package com.example.demo.DAO;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class) // Enable auditing for createdAt and updatedAt
public class student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_id;

	@Column(name = "stud_name", nullable = true)
	private String name;

	@Column(nullable = false)
	private int age;

	@Column(name = "s_mark", nullable = false)
	private double marks;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt; // Use LocalDateTime for auditing fields

	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime updatedAt;

	// Getters and Setters

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
