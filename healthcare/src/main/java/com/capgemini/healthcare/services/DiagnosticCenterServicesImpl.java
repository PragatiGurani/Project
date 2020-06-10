package com.capgemini.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.DiagnosticCenterDao;
import com.capgemini.healthcare.dao.TestDao;
import com.capgemini.healthcare.dto.DiagnosticCenterBean;
import com.capgemini.healthcare.dto.TestBean;

@Service
public class DiagnosticCenterServicesImpl implements DiagnosticCenterServices {

	@Autowired
	private DiagnosticCenterDao dao;
	@Autowired
	private TestDao testDao;

	@Override
	public boolean addCenter(DiagnosticCenterBean diagnosticCenterBean) {

				TestBean test = new TestBean();
				test.setTestName("Blood Pressure");
				test.setCenterId(diagnosticCenterBean.getCenterId());
				testDao.addTest(test);
				TestBean test1 = new TestBean();
				test1.setTestName("Blood Group");
				test1.setCenterId(diagnosticCenterBean.getCenterId());
				testDao.addTest(test1);
				TestBean test2 = new TestBean();
				test2.setTestName("Blood Sugar");
				test2.setCenterId(diagnosticCenterBean.getCenterId());
				testDao.addTest(test2);

				return dao.addCenter(diagnosticCenterBean);
	}

	@Override
	public boolean deleteCenter(String centerId) {
		testDao.deleteTest(centerId);
		return dao.deleteCenter(centerId);
	}

	@Override
	public boolean modifyCenter(String centerId, String centerName) {
				return dao.modifyCenter(centerId, centerName);
	}

	@Override
	public DiagnosticCenterBean searchCenter(String centerId) {
			return dao.searchCenter(centerId);
	}

	@Override
	public List<DiagnosticCenterBean> getAllCenter() {
		return dao.getAllCenter();
	}

}