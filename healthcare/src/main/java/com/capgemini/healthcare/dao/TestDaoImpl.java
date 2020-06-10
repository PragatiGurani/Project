package com.capgemini.healthcare.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.TestBean;
import com.capgemini.healthcare.exception.TestException;

@Repository
public class TestDaoImpl implements TestDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addTest(TestBean testBean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(testBean);
			transaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new TestException("TestId already exist..Enter unique TestId..");
		}
	}

	@Override
	public boolean deleteTest(String centerId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from TestBean where centerId= :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", centerId);
		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new TestException("CenterId doesnot Exist");
	}

	@Override
	public boolean modifyTest(int testId, String testName, String centerId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			TestBean bean = entityManager.find(TestBean.class, testId);
			bean.setTestId(testId);
			bean.setTestName(testName);
			bean.setCenterId(centerId);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new TestException("TestDetails not updated..TryAgain");
		}
		entityManager.close();
		return true;
	}

	@Override
	public TestBean searchTest(int testId) {
		EntityTransaction transaction = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			TestBean bean = entityManager.find(TestBean.class, testId);
			transaction.commit();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			transaction.rollback();
			throw new TestException("TestId doesnot Exist");
		}
	}

	@Override
	public List<TestBean> getAllTest() {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "from TestBean";
			Query query = entityManager.createQuery(jpql);
			List<TestBean> list = query.getResultList();
			entityManager.close();
			return list;
		} catch (Exception e) {
			transaction.rollback();
			throw new TestException("No Test Details exist to display..");
		}
	}

}
