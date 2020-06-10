package com.capgemini.healthcare.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.TestBean;
import com.capgemini.healthcare.dto.TestResponse;
import com.capgemini.healthcare.services.TestServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class TestController {

	@Autowired
	private TestServices service;
	
	@PostMapping(path = "/add-test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse addTest(@RequestBody TestBean testBean) {
		TestResponse testResponse = new TestResponse();
		if (service.addTest(testBean)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Details added Successfully.....");
		}
		return testResponse;
	}
	
	@DeleteMapping(path = "/delete-test/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse deleteTest(@PathVariable("centerId") String centerId) {
		TestResponse testResponse = new TestResponse();
		if(service.deleteTest(centerId)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Test Deleted Successfully.....");
		}
		return testResponse;
	}
	
	@GetMapping(path = "/getAll-test", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse searchAllTest() {
		TestResponse testResponse = new TestResponse();
		List<TestBean> list = service.getAllTest();
		if (!list.isEmpty()) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription(" Test Details found Successfully");
			testResponse.setBean(list);
		} 
		return testResponse;
	}
	
	@PutMapping(path = "/modify-test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse changeTest(@RequestBody TestBean testBean) {
		TestResponse testResponse = new TestResponse();
		if (service.modifyTest(testBean.getTestId(), testBean.getTestName() , testBean.getCenterId())) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("TestDetails updated Successfully....");
		} 
		return testResponse;
	}
	
	@GetMapping(path = "/get-test/{testId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse searchTest(@PathVariable("testId") int testId) {
		TestResponse testResponse = new TestResponse();
		TestBean testBean = service.searchTest(testId);
		if (testBean!=null) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDescription("Data found");
			testResponse.setBean(Arrays.asList(testBean));
		} 
		else {
			testResponse.setStatusCode(401);
			testResponse.setMessage("failed");
			testResponse.setDescription("Details not found....");
		}
		return testResponse;
	}
	
}
