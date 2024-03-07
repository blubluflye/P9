package com.microservice.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.client.beans.PatientInfo;
import com.microservice.client.dto.TestResultDto;
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
	
	// return a response en json contenant la string car le result ne s'affiche car non json(faire un dto)
	@GetMapping("/TestDb/{id}")
	public ResponseEntity<TestResultDto> testdb(@PathVariable Integer id){
		PatientInfo patientInfo = new PatientInfo(patientsProxy.getPatient(id),noteProxy.getPatientNote(id));
		TestResultDto result = new TestResultDto(testDbProxy.testDiabete(patientInfo));
		return ResponseEntity.ok(result);
	}

}
