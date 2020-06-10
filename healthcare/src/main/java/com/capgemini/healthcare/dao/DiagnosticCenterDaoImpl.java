package com.capgemini.healthcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.DiagnosticCenterBean;
import com.capgemini.healthcare.exception.CenterException;

@Repository
public class DiagnosticCenterDaoImpl implements DiagnosticCenterDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addCenter(DiagnosticCenterBean diagnosticCenterBean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(diagnosticCenterBean);
			transaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			throw new CenterException("Center Id already exist..Please enter unique CenterId..");
		}
	}
	
	@Override
	public boolean deleteCenter(String centerId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql="delete from DiagnosticCenterBean where centerId= :id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", centerId);
			int i=query.executeUpdate();
			transaction.commit();	
			if(i>0 ) {
			return true;
			}
			throw new CenterException("CenterId doesnot Exist");
	}

	@Override
	public boolean modifyCenter(String centerId, String centerName) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			DiagnosticCenterBean bean = entityManager.find(DiagnosticCenterBean.class, centerId);
			bean.setCenterId(centerId);
			bean.setCenterName(centerName);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new CenterException("DiagnosticCenterDetails not updated..TryAgain");
		}
		entityManager.close();
		return true;
	}

	@Override
	public DiagnosticCenterBean searchCenter(String centerId) {
		EntityTransaction transaction = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			DiagnosticCenterBean bean = entityManager.find(DiagnosticCenterBean.class, centerId);
			transaction.commit();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			transaction.rollback();
			throw new CenterException("CenterId doesnot Exist");
		}
	}

	@Override
	public List<DiagnosticCenterBean> getAllCenter() {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "from DiagnosticCenterBean";
			Query query = entityManager.createQuery(jpql);
			List<DiagnosticCenterBean> list = query.getResultList();
			entityManager.close();
			return list;
		} catch (Exception e) {
			transaction.rollback();
			throw new CenterException("DiagnosticCenter Details doesnot Exist");
		}
	}

}
