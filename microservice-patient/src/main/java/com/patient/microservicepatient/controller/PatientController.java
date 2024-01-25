package com.patient.microservicepatient.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patient.microservicepatient.models.Patient;
import com.patient.microservicepatient.services.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/patients")
	public List<Patient> getPatients(){
		return patientService.findAll();
	}
	
	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable Integer id) {
		return patientService.findById(id);
	}
	
	@PostMapping("/patients")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) throws URISyntaxException {
		Patient savedPatient = patientService.create(patient);
		return ResponseEntity.created(new URI("/patients" + savedPatient.getId())).body(savedPatient);
	}
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Integer id,@RequestBody Patient patient) throws URISyntaxException {
		return ResponseEntity.ok(patientService.update(id, patient));
	}
}
