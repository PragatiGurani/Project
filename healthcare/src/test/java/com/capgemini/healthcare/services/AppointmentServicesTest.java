package com.capgemini.healthcare.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentServicesTest {

	@Autowired
	AppointmentServices appointmentServices;

	@Test
	public void getAllAppointment() {
		assertNotNull(appointmentServices.getAllAppointment());
	}
}
