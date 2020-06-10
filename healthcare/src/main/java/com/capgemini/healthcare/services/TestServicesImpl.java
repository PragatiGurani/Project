package com.capgemini.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.DiagnosticCenterDao;
import com.capgemini.healthcare.dao.TestDao;
import com.capgemini.healthcare.dto.TestBean;
import com.capgemini.healthcare.exception.TestException;

@Service
public class TestServicesImpl implements TestServices {

	@Autowired
	private TestDao dao;
	@Autowired
	private DiagnosticCenterDao centerDao;

	@Override
	public boolean addTest(TestBean testBean) {

		if (centerDao.searchCenter(testBean.getCenterId()) == null) {
			throw new TestException("Enter CenterId existing in DiagnosticCenter database..");
		} else {
			return dao.addTest(testBean);
		}
	}

	@Override
	public boolean deleteTest(String centerId) {
		return dao.deleteTest(centerId);
	}

	@Override
	public boolean modifyTest(int testId, String testName, String centerId) {
		if (centerDao.searchCenter(centerId) == null) { // it checks for centerId if it present in
														// centerTable then only updates
			throw new TestException("Enter CenterId existing in DiagnosticCenter database..so that it modifies");
		} else {
			return dao.modifyTest(testId, testName, centerId);
		}
	}

	@Override
	public TestBean searchTest(int testId) {
		return dao.searchTest(testId);
	}

	@Override
	public List<TestBean> getAllTest() {
		return dao.getAllTest();
	}

}
