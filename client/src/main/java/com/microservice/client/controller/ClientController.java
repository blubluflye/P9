package com.microservice.client.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.client.beans.PatientBean;
import com.microservice.client.proxies.MicroservicePatientProxy;

@RestController
public class ClientController {
	private final MicroservicePatientProxy patientsProxy;
	
	public ClientController(MicroservicePatientProxy patientsProxy) {
		this.patientsProxy = patientsProxy;
	}
	
	@GetMapping("/")
	public List<PatientBean> accueil(){
		return patientsProxy.getAllPatient();
	}
}
