package com.patient.microservicepatient.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.microservicepatient.models.Patient;
import com.patient.microservicepatient.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public Patient findById(Integer id){
		return patientRepository.findById(id).orElseThrow(RuntimeException::new);	
	}
	
	public Patient create(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public Patient update(Integer id, Patient patient) {
		Patient currentPatient = patientRepository.findById(id).orElseThrow(RuntimeException::new);
		currentPatient.setSurname(patient.getSurname());
		currentPatient.setName(patient.getName());
		currentPatient.setAddress(patient.getAddress());
		currentPatient.setTelephone(patient.getTelephone());
		currentPatient.setGenre(patient.getGenre());
		currentPatient.setBirthdate(patient.getBirthdate());
		currentPatient = patientRepository.save(currentPatient);
		return currentPatient;
	}

	public List<Patient> findAll() {
		return patientRepository.findAll();
	}
}
