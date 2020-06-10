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

import com.capgemini.healthcare.dto.DiagnosticCenterBean;
import com.capgemini.healthcare.dto.DiagnosticCenterResponse;
import com.capgemini.healthcare.services.DiagnosticCenterServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class DiagnosticCenterController {

	@Autowired
	private DiagnosticCenterServices service;
	
	@PostMapping(path = "/add-center", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse addCenter(@RequestBody DiagnosticCenterBean diagnosticCenterBean) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		if (service.addCenter(diagnosticCenterBean)) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription("DiagnosticCenter Details added Successfully.....");
		} 
		return diagnosticCenterResponse;
	}
	
	@DeleteMapping(path = "/delete-center/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse deleteCenter(@PathVariable("centerId") String centerId) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		if(service.deleteCenter(centerId)) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription("Center Deleted Successfully.....");
		} 
		return diagnosticCenterResponse;
	}
	
	@GetMapping(path = "/getAll-center", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse searchAllCenter() {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		List<DiagnosticCenterBean> list = service.getAllCenter();
		if (!list.isEmpty()) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription(" Center Details found Successfully");
			diagnosticCenterResponse.setBean(list);
		} 
		return diagnosticCenterResponse;
	}	
	
	@PutMapping(path = "/modify-center", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse changeCenter(@RequestBody DiagnosticCenterBean diagnosticCenterBean) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		if (service.modifyCenter(diagnosticCenterBean.getCenterId(), diagnosticCenterBean.getCenterName())) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription("CenterDetails updated Successfully....");
		} 
		return diagnosticCenterResponse;
	}
	
	@GetMapping(path = "/get-center/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse searchCenter(@PathVariable("centerId") String centerId) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		DiagnosticCenterBean diagnosticCenterBean = service.searchCenter(centerId);
		if (diagnosticCenterBean!=null) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDescription("Data found");
			diagnosticCenterResponse.setBean(Arrays.asList(diagnosticCenterBean));
		} 
		else {
			diagnosticCenterResponse.setStatusCode(401);
			diagnosticCenterResponse.setMessage("failed");
			diagnosticCenterResponse.setDescription("Details not found....");
		}
		return diagnosticCenterResponse;
	}
	
}