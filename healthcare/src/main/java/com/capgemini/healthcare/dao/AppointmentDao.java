package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.dto.AppointmentBean;

public interface AppointmentDao {

	List<AppointmentBean> getAllAppointment();
	
	boolean appointmentApprove(int appointmentId, String userId, 
			String userName, String testName, String dateTime, String centerId, String appointmentStatus);
	
}
