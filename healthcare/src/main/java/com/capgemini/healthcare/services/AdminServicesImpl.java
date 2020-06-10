package com.capgemini.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.AdminDao;
import com.capgemini.healthcare.dto.LoginBean;

@Service
public class AdminServicesImpl implements AdminServices {

	@Autowired
	private AdminDao dao;

	@Override
	public LoginBean login(LoginBean credentials) {
		return dao.login(credentials);
	}
}
