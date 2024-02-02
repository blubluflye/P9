package com.microservice.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.client.beans.PatientBean;
import com.microservice.client.proxies.MicroservicePatientProxy;

@RestController
public class ClientController {
	@Autowired
	private MicroservicePatientProxy patientsProxy;
	
	public ClientController(MicroservicePatientProxy patientsProxy) {
		this.patientsProxy = patientsProxy;
	}
	
	@GetMapping("/patients")
	public List<PatientBean> accueil(){
		return patientsProxy.getAllPatient();
	}
	
	@GetMapping("/patients/{id}")
	public PatientBean getPatientById(@PathVariable Integer id) {
		return patientsProxy.getPatient(id);
	}
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<PatientBean> updatePatient(@PathVariable Integer id, @RequestBody PatientBean patient)
	{
		patientsProxy.updatePatient(id, patient);
		return ResponseEntity.ok(patient);
	}
	
	@PostMapping("/patients/")
	public ResponseEntity<PatientBean> createPatient(@RequestBody PatientBean patient)
	{
		patientsProxy.createPatient(patient);
		return ResponseEntity.ok(patient);
	}
}
