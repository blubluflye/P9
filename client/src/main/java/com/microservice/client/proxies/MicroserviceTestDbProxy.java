package com.microservice.client.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.client.beans.PatientInfo;

@FeignClient(name = "microservice-test-diabete")
@RibbonClient(name = "microservice-test-diabete")
public interface MicroserviceTestDbProxy {
	@PostMapping("/testDb/")
	public String testDiabete(@RequestBody PatientInfo patientInfo);
}
