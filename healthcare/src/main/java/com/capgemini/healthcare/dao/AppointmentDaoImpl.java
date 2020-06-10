package com.capgemini.healthcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.AppointmentBean;
import com.capgemini.healthcare.exception.AppointmentException;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public List<AppointmentBean> getAllAppointment() {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "from AppointmentBean";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<AppointmentBean> list = query.getResultList();
			entityManager.close();
			return list;
		} catch (Exception e) {
			transaction.rollback();
			throw new AppointmentException("No Appointment Details found to display..");
		}
	}

	@Override
	public boolean appointmentApprove(int appointmentId, String userId, String userName, String testName,
			String dateTime, String centerId, String appointmentStatus) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			AppointmentBean bean = entityManager.find(AppointmentBean.class, appointmentId);
			bean.setAppointmentId(appointmentId);
			bean.setCenterId(centerId);
			bean.setDateTime(dateTime);
			bean.setTestName(testName);
			bean.setUserId(userId);
			bean.setUserName(userName);
			bean.setAppointmentStatus(appointmentStatus);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new AppointmentException("ApproveAppoinment not approved..");
		}
		entityManager.close();
		return true;
	}

}
