package com.capgemini.healthcare.dao;

import com.capgemini.healthcare.dto.LoginBean;

public interface AdminDao {
	
	public LoginBean login(LoginBean credentials);
	
}
