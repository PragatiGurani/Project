package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.dto.DiagnosticCenterBean;

public interface DiagnosticCenterDao {

	boolean addCenter(DiagnosticCenterBean diagnosticCenterBean);

	boolean deleteCenter(String centerId);
	
	boolean modifyCenter(String centerId, String centerName);
	
	DiagnosticCenterBean searchCenter(String centerId);

	List<DiagnosticCenterBean> getAllCenter();
	
}
