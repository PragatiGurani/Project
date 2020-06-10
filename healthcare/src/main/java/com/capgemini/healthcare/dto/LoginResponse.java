package com.capgemini.healthcare.dto;

import java.util.List;

public class LoginResponse {

	private int statusCode;
	private String message;
	private String description;
    private List<LoginBean> bean;
    private String loginType;
    
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
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
	public List<LoginBean> getBean() {
		return bean;
	}
	public void setBean(List<LoginBean> bean) {
		this.bean = bean;
	}
    
     
}
