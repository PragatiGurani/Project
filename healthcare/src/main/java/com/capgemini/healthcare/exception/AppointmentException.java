package com.capgemini.healthcare.exception;

@SuppressWarnings("serial")
public class AppointmentException extends RuntimeException{

	public AppointmentException(String message) {
		super(message);	
	}
}