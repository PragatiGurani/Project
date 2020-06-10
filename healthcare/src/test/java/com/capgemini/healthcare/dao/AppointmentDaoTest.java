package com.capgemini.healthcare.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentDaoTest {

	@Autowired
	AppointmentDao appointmentDao;

	@Test
	public void getAllAppointment() {
		assertNotNull(appointmentDao.getAllAppointment());
	}
}
