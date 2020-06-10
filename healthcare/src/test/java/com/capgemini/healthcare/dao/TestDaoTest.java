package com.capgemini.healthcare.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.healthcare.dto.TestBean;

@SpringBootTest
public class TestDaoTest {

	@Autowired
	TestDao testDao;

	@Test
	public void addTest() {
		TestBean testBean = new TestBean();
		testBean.setCenterId("Ba12");
		testBean.setTestName("Heart");
		assertTrue(testDao.addTest(testBean));
		testDao.deleteTest(testBean.getCenterId());
	}

	@Test
	public void deleteTest() {
		TestBean testBean = new TestBean();
		testBean.setCenterId("Ba12");
		testBean.setTestName("Heart");
		testDao.addTest(testBean);
		assertTrue(testDao.deleteTest("Ba12"));
	}

	@Test
	public void getAllTest() {
		 assertNotNull(testDao.getAllTest());
	}

	@Test
	public void modifyTest() {
		TestBean testBean = new TestBean();
		testBean.setCenterId("Ba12");
		testBean.setTestName("Heart");
		testDao.addTest(testBean);
		assertTrue(testDao.modifyTest(testBean.getTestId(), "Kidney", "ut12"));
		testDao.deleteTest("ut12");
	}

	@Test
	public void searchTest() {
		TestBean testBean = new TestBean();
		testBean.setCenterId("Ba12");
		testBean.setTestName("Heart");
		testDao.addTest(testBean);
		assertNotNull(testDao.searchTest(testBean.getTestId()));
		testDao.deleteTest(testBean.getCenterId());
	}
}
