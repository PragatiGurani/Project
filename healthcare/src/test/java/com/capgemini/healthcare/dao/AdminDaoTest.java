package com.capgemini.healthcare.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.capgemini.healthcare.dto.LoginBean;

@SpringBootTest
public class AdminDaoTest {

	@Autowired
	AdminDao adminDao;

	@Test
	public void login() {
		LoginBean loginBean = new LoginBean();
		loginBean.setId(576);
		loginBean.setUserName("Pragati");
		loginBean.setPassword("Pragati@123");
		loginBean.setLoginType("Admin");
		adminDao.login(loginBean);
		assertNotNull(adminDao.login(loginBean));
	}
}
