package com.patient.microservicepatient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.microservicepatient.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
