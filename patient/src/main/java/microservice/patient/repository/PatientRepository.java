package microservice.patient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import microservice.patient.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String>{

	 List<Patient> findByName(String name);
	 
	 Patient findByNameAndSurname(String name, String surname);

}
