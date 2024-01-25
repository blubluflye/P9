package com.microservice.client.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.client.beans.PatientBean;

@FeignClient(name = "microservice-patients", url= "localhost:9001")
public interface MicroservicePatientProxy {
	@GetMapping(value= "/patients")
	List<PatientBean> getAllPatient();
	
	@GetMapping("/patients/{id}")
	PatientBean getPatient(@PathVariable Integer id);
	
	@PutMapping("/patients/{id}")
	String updatePatient(@PathVariable Integer id, @RequestBody PatientBean patient);
	
	@PostMapping("/patients")
	String createPatient(@RequestBody PatientBean patient);
}
