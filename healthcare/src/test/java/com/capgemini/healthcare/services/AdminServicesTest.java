package com.capgemini.healthcare.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcare.dto.LoginBean;

@SpringBootTest
public class AdminServicesTest {

	@Autowired
	AdminServices adminServices;

	@Test
	public void login() {
		LoginBean loginBean = new LoginBean();
		loginBean.setId(576);
		loginBean.setUserName("Pragati");
		loginBean.setPassword("Pragati@123");
		loginBean.setLoginType("Admin");
		adminServices.login(loginBean);
		assertNotNull(adminServices.login(loginBean));
	}
}
