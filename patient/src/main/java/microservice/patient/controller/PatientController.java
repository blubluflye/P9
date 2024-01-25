package microservice.patient.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import microservice.patient.model.Patient;
import microservice.patient.repository.PatientRepository;


@RestController
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping("/patient/getById{id}")
	public Patient getAllPatient(@PathVariable String id){
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isPresent())
			return patientRepository.findById(id).get();
		return null;
	}
	
	@GetMapping("/patient/getAll")
	public List<Patient> getAllPatient(){
		return patientRepository.findAll();
	}
	@GetMapping("/patient/get")
	public Patient getPatient(@RequestParam String name, @RequestParam String surname) {
        return patientRepository.findByNameAndSurname(name, surname);
    }
	
	@PutMapping("/patient/update{id}")
	public String updatePatient(@PathVariable String id, @RequestBody Patient patient) {
		Patient patientToUpdate;
		if ((patientToUpdate =patientRepository.findById(id).get()) != null)
		{
			patientToUpdate.setSurname(patient.getSurname());
			patientToUpdate.setName(patient.getName());
			patientToUpdate.setAddress(patient.getAddress());
			patientToUpdate.setTelephone(patient.getTelephone());
			patientRepository.save(patientToUpdate);
			return "patient updated";
		}
		return "user : " + patient.getName() + " " + patient.getSurname() + " doesn't exist";	
	}
	
	@PostMapping("/patient/create")
	/*
	 * TODO: seul le téléphone et l'addresse peuvent être vide pour une création 
	 */
	public String createPatient(@RequestBody Patient patient) {
		if ((patientRepository.findByNameAndSurname(patient.getName(), patient.getSurname())) == null) {

			patientRepository.save(patient);
			return "patient added";
		}
		return "user : " + patient.getName() + " " + patient.getSurname() + " already existing";
	}
	

}
