package com.capgemini.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.AppointmentBean;
import com.capgemini.healthcare.dto.AppointmentResponse;
import com.capgemini.healthcare.services.AppointmentServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AppointmentController {

	@Autowired
	private AppointmentServices service;

	@GetMapping(path = "/getAll-Appointment", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse searchAllAppointment() {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<AppointmentBean> list = service.getAllAppointment();
		if (!list.isEmpty()) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription(" Appointment Details found Successfully");
			appointmentResponse.setBean(list);
		}
		return appointmentResponse;
	}

	@PutMapping(path = "/approve-appointment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse approveAppointment(@RequestBody AppointmentBean appointmentBean) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (service.appointmentApprove(appointmentBean.getAppointmentId(), appointmentBean.getUserId(),
				appointmentBean.getUserName(), appointmentBean.getTestName(), appointmentBean.getDateTime(), 
				appointmentBean.getCenterId(), appointmentBean.getAppointmentStatus())) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment approved....");
		} 
		return appointmentResponse;
	}
}
