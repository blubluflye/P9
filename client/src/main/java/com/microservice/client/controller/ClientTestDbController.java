package com.microservice.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.pattern.PathPattern.PathMatchInfo;

import com.microservice.client.beans.PatientBean;
import com.microservice.client.beans.PatientInfo;
import com.microservice.client.proxies.MicroserviceNoteProxy;
import com.microservice.client.proxies.MicroservicePatientProxy;
import com.microservice.client.proxies.MicroserviceTestDbProxy;

@RestController
public class ClientTestDbController {
	@Autowired
	private MicroservicePatientProxy patientsProxy;
	
	@Autowired
	private MicroserviceNoteProxy noteProxy;
	
	@Autowired
	private MicroserviceTestDbProxy testDbProxy;
	
	@GetMapping("/TestDb/{id}")
	public String testdb(@PathVariable Integer id){
		PatientInfo patientInfo = new PatientInfo(patientsProxy.getPatient(id),noteProxy.getPatientNote(id)); 
		return testDbProxy.testDiabete(patientInfo);
	}

}
