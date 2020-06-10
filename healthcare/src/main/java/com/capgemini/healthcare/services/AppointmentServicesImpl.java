package com.capgemini.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.AppointmentDao;
import com.capgemini.healthcare.dto.AppointmentBean;

@Service
public class AppointmentServicesImpl implements AppointmentServices{

	@Autowired
	private AppointmentDao dao;
	
	@Override
	public List<AppointmentBean> getAllAppointment() {
		return dao.getAllAppointment();
	}

	@Override
	public boolean appointmentApprove(int appointmentId, String userId, String userName, String testName,
			String dateTime, String centerId, String appointmentStatus) {
		return dao.appointmentApprove(appointmentId, userId, userName, testName, dateTime, centerId, appointmentStatus);
	}


}
