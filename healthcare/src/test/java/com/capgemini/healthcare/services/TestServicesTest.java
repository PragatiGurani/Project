package com.capgemini.healthcare.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcare.dto.TestBean;

@SpringBootTest
public class TestServicesTest {

	@Autowired
	TestServices testServices;

	@Test
	public void addTest() {
		TestBean testBean = new TestBean();
		testBean.setCenterId("Ba145");
		testBean.setTestName("Heart");
		assertTrue(testServices.addTest(testBean));
		testServices.deleteTest(testBean.getCenterId());
	}

	@Test
	public void deleteTest() {
		TestBean testBean = new TestBean();
		testBean.setCenterId("Ba14");
		testBean.setTestName("Kidney");
		testServices.addTest(testBean);
		assertTrue(testServices.deleteTest("Ba14"));
	}

	@Test
	public void getAllTest() {
		assertNotNull(testServices.getAllTest());
	}

	@Test
	public void modifyTest() {
		TestBean testBean = new TestBean();
		testBean.setCenterId("pa56");
		testBean.setTestName("Kidney");
		testServices.addTest(testBean);
		assertTrue(testServices.modifyTest(testBean.getTestId(), "heart", "mn8"));
		testServices.deleteTest("mn8");
	}

	@Test
	public void searchTest() {
		TestBean testBean = new TestBean();
		testBean.setCenterId("Gh34");
		testBean.setTestName("Liver");
		testServices.addTest(testBean);
		assertNotNull(testServices.searchTest(testBean.getTestId()));
		testServices.deleteTest(testBean.getCenterId());
	}
}
