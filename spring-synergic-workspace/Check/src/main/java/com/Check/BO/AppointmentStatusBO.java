package com.Check.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Check.Repo.AppointmentStatusRepo;

@Component
public class AppointmentStatusBO {

	@Autowired
	AppointmentStatusRepo appointmentStatus;
}
