package com.microservice.client.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservice.client.beans.PatientBean;

@FeignClient(name = "microservice-patients", url= "localhost:9001")
public interface MicroservicePatientProxy {
	@GetMapping(value= "/patient/getAll")
	List<PatientBean> getAllPatient();
}
