package com.microservice.client.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.client.beans.PatientBean;
import com.microservice.client.proxies.MicroservicePatientProxy;

@RestController
public class ClientController {
	private final MicroservicePatientProxy patientsProxy;
	
	public ClientController(MicroservicePatientProxy patientsProxy) {
		this.patientsProxy = patientsProxy;
	}
	
	@GetMapping("/patients")
	public List<PatientBean> accueil(){
		return patientsProxy.getAllPatient();
	}
	
	@GetMapping("/patient{id}")
	public PatientBean getPatientById(@PathVariable String id) {
		return patientsProxy.getPatient(id);
	}
	
	
}
