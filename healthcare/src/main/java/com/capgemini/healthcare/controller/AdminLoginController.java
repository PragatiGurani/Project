package com.capgemini.healthcare.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.LoginBean;
import com.capgemini.healthcare.dto.LoginResponse;
import com.capgemini.healthcare.services.AdminServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AdminLoginController {

	@Autowired
	private AdminServices service;
	
	@PostMapping(path = "/auth-Admin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse auth(@RequestBody LoginBean credentials) {

		LoginResponse response = new LoginResponse();
		LoginBean account = service.login(credentials);
		if (account !=null) {
			response.setStatusCode(201);
			response.setDescription("Success");
			response.setMessage("Admin logged in successfully........");
			response.setBean(Arrays.asList(account));
			response.setLoginType(account.getLoginType());
		}
		return response;
	}
	
}
