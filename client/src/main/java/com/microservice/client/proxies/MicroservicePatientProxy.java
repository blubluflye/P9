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
 * abandon zuul server
 * à remplacer par pour tester avec zuul server si ça fonctionne
 * @FeignClient(name = "zuul-server")
 */
@FeignClient(name = "microservice-patients")
@RibbonClient(name = "microservice-patients")
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
