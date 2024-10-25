package com.Check.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Check.BO.AppointmentStatusBO;

@Service
public class AppointmentStatusService {
	@Autowired
	AppointmentStatusBO appointmentStatusBO;
}
