package com.microservice.client.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.client.beans.PatientBean;

/*
 * à remplacer par pour tester avec zuul server si ça fonctionne
 * @FeignClient(name = "zuul-server")
 */
@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-patients")
public interface MicroservicePatientProxy {
	@GetMapping(value= "/microservice-patients/patients")
	List<PatientBean> getAllPatient();
	
	@GetMapping("/microservice-patients/patients/{id}")
	PatientBean getPatient(@PathVariable Integer id);
	
	@PutMapping("/microservice-patients/patients/{id}")
	String updatePatient(@PathVariable Integer id, @RequestBody PatientBean patient);
	
	@PostMapping("/microservice-patients/patients")
	String createPatient(@RequestBody PatientBean patient);
}
