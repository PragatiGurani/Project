package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.dto.TestBean;

public interface TestDao {

	boolean addTest(TestBean testBean);
	
	boolean deleteTest(String centerId);

	boolean modifyTest(int testId, String testName,String centerId);

	TestBean searchTest(int testId);

	List<TestBean> getAllTest();

}
