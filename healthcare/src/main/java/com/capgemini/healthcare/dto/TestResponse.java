package com.capgemini.healthcare.dto;

import java.util.List;

public class TestResponse {

	private int statusCode;
	private String message;
	private String description;
    private List<TestBean> bean;
    
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
	public List<TestBean> getBean() {
		return bean;
	}
	public void setBean(List<TestBean> bean) {
		this.bean = bean;
	}
    
}
