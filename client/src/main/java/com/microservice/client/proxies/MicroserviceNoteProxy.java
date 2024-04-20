package com.microservice.client.proxies;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.client.beans.NoteBean;

@FeignClient(name = "microservice-notes")
@RibbonClient(name = "microservice-notes")
public interface MicroserviceNoteProxy {

	@GetMapping("/notes/{id}")
	public List<NoteBean> getPatientNote(@PathVariable Integer id);
	@PostMapping("/notes/{patId}")
	public ResponseEntity<NoteBean> createNote(@PathVariable Integer patId, @RequestBody NoteBean note) throws URISyntaxException;
}
