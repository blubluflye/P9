package com.p9.microservicetestdiabete.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.p9.microservicetestdiabete.beans.PatientInfo;
import com.p9.microservicetestdiabete.service.TestDiabeteService;

@RestController
public class TestDiabeteController {

	@Autowired
	private TestDiabeteService testDiabeteService;
	
	@PostMapping("/testDb/")
	public String testDiabete(@RequestBody PatientInfo patientInfo) {
		return testDiabeteService.testdiabete(patientInfo);
	}
}
