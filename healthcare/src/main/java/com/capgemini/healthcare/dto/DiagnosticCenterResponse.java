package com.capgemini.healthcare.dto;

import java.util.List;

public class DiagnosticCenterResponse {

	private int statusCode;
	private String message;
	private String description;
    private List<DiagnosticCenterBean> bean;
    
    
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
	public List<DiagnosticCenterBean> getBean() {
		return bean;
	}
	public void setBean(List<DiagnosticCenterBean> bean) {
		this.bean = bean;
	}
    
	
}
