package com.capgemini.healthcare.services;

import java.util.List;

import com.capgemini.healthcare.dto.TestBean;

public interface TestServices {

	boolean addTest(TestBean testBean);
	
	boolean deleteTest(String centerId);
	
	boolean modifyTest(int testId, String testName, String centerId);

	TestBean searchTest(int testId);

	List<TestBean> getAllTest();
	
}
