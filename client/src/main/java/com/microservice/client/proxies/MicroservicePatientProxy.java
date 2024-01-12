package com.microservice.client.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.client.beans.PatientBean;

@FeignClient(name = "microservice-patients", url= "localhost:9001")
public interface MicroservicePatientProxy {
	@GetMapping(value= "/patient/getAll")
	List<PatientBean> getAllPatient();
	
	@GetMapping("/patient/getById{id}")
	PatientBean getPatient(@PathVariable String id);
	
	@PostMapping("/patient/update")
	String updatePatient(@RequestBody PatientBean patient);
	
	@PostMapping("/patient/create")
	String createPatient(@RequestBody PatientBean patient);
}
