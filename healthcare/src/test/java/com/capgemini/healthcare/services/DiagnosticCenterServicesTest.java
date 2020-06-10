package com.capgemini.healthcare.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcare.dto.DiagnosticCenterBean;

@SpringBootTest
public class DiagnosticCenterServicesTest {

	@Autowired
	DiagnosticCenterServices centerServices;
	
  @Test
  public void addCenter() {
	  DiagnosticCenterBean centerBean = new DiagnosticCenterBean();
		centerBean.setCenterId("mg12");
		centerBean.setCenterName("Vijay");
		assertTrue(centerServices.addCenter(centerBean));
		centerServices.deleteCenter(centerBean.getCenterId());
  }

  @Test
  public void deleteCenter() {
	  DiagnosticCenterBean centerBean = new DiagnosticCenterBean();
		centerBean.setCenterId("mnkl");
		centerBean.setCenterName("sanju");
		centerServices.addCenter(centerBean);
		assertTrue(centerServices.deleteCenter("mnkl"));
  }

  @Test
  public void getAllCenter() {
	  assertNotNull(centerServices.getAllCenter());
  }

  @Test
  public void searchCenter() {
	  DiagnosticCenterBean centerBean = new DiagnosticCenterBean();
		centerBean.setCenterId("bn12");
		centerBean.setCenterName("Manvita");
		centerServices.addCenter(centerBean);
		assertNotNull(centerServices.searchCenter(centerBean.getCenterId()));
		centerServices.deleteCenter(centerBean.getCenterId());
  }
}
