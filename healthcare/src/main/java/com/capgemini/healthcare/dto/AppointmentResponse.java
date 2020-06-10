package com.capgemini.healthcare.dto;

import java.util.List;

public class AppointmentResponse {

	private int statusCode;
	private String message;
	private String description;
    private List<AppointmentBean> bean;
    
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<AppointmentBean> getBean() {
		return bean;
	}
	public void setBean(List<AppointmentBean> bean) {
		this.bean = bean;
	}
    
}
