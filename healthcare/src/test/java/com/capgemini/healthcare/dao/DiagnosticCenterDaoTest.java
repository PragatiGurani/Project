package com.capgemini.healthcare.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcare.dto.DiagnosticCenterBean;

@SpringBootTest
public class DiagnosticCenterDaoTest {

	@Autowired
	DiagnosticCenterDao centerDao;

	@Test
	public void addCenter() {
		DiagnosticCenterBean centerBean = new DiagnosticCenterBean();
		centerBean.setCenterId("uy12");
		centerBean.setCenterName("Vijaya");
		assertTrue(centerDao.addCenter(centerBean));
		centerDao.deleteCenter(centerBean.getCenterId());
	}

	@Test
	public void deleteCenter() {
		DiagnosticCenterBean centerBean = new DiagnosticCenterBean();
		centerBean.setCenterId("qwet");
		centerBean.setCenterName("Kerudi");
		centerDao.addCenter(centerBean);
		assertTrue(centerDao.deleteCenter("qwe"));
	}

	@Test
	public void getAllCenter() {
		assertNotNull(centerDao.getAllCenter());
	}

	@Test
	public void modifyCenter() {
		DiagnosticCenterBean centerBean = new DiagnosticCenterBean();
		centerBean.setCenterId("qwu12");
		centerBean.setCenterName("Vinaya");
		centerDao.addCenter(centerBean);
		assertTrue(centerDao.modifyCenter("qwu12", "Vinay"));
		centerDao.deleteCenter("qwu12");
	}

	@Test
	public void searchCenter() {
		DiagnosticCenterBean centerBean = new DiagnosticCenterBean();
		centerBean.setCenterId("pl12");
		centerBean.setCenterName("Manvi");
		centerDao.addCenter(centerBean);
		assertNotNull(centerDao.searchCenter(centerBean.getCenterId()));
		centerDao.deleteCenter(centerBean.getCenterId());
	}
}
