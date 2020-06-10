package com.capgemini.healthcare.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.LoginBean;
import com.capgemini.healthcare.exception.LoginException;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public LoginBean login(LoginBean credentials) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from LoginBean where userName=:userName and password=:password";
		TypedQuery<LoginBean> query = entityManager.createQuery(jpql, LoginBean.class);
		query.setParameter("userName", credentials.getUserName());
		query.setParameter("password", credentials.getPassword());
		try {
			LoginBean loginBean = query.getSingleResult();
			if (loginBean.getPassword().equals(credentials.getPassword())) {
				return loginBean;
			} else {
				System.out.println("Credentials are valid..");
				return null;
			}
		} catch (Exception e) {
			throw new LoginException("Please Enter valid name and password.....Try Again");
		}
	}

}
