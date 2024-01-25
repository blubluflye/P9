package com.patient.microservicepatient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.microservicepatient.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
