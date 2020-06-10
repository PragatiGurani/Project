package com.capgemini.healthcare.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.healthcare.dto.AppointmentResponse;
import com.capgemini.healthcare.dto.DiagnosticCenterResponse;
import com.capgemini.healthcare.dto.LoginResponse;
import com.capgemini.healthcare.dto.TestResponse;
import com.capgemini.healthcare.exception.AppointmentException;
import com.capgemini.healthcare.exception.CenterException;
import com.capgemini.healthcare.exception.LoginException;
import com.capgemini.healthcare.exception.TestException;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(TestException.class)
	public TestResponse handleTestException(TestException e) {
		TestResponse response = new TestResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
	
	@ExceptionHandler(CenterException.class)
	public DiagnosticCenterResponse handleCenterException(CenterException e) {
		DiagnosticCenterResponse response = new DiagnosticCenterResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
	
	@ExceptionHandler(LoginException.class)
	public LoginResponse handleLoginException(LoginException e) {
		LoginResponse response = new LoginResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
	
	@ExceptionHandler(AppointmentException.class)
	public AppointmentResponse handleAppointmentException(AppointmentException e) {
		AppointmentResponse response = new AppointmentResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
}
