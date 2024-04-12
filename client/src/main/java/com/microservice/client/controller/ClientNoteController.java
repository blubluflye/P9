package com.microservice.client.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.client.beans.NoteBean;
import com.microservice.client.proxies.MicroserviceNoteProxy;

@RestController
public class ClientNoteController {
	
	@Autowired
	private MicroserviceNoteProxy notesProxy;

	public ClientNoteController(MicroserviceNoteProxy notesProxy) {
		this.notesProxy = notesProxy;
	}
	
	@GetMapping("/notes/{patId}")
	public List<NoteBean> getPatientNotes(@PathVariable Integer patId){
		return notesProxy.getPatientNote(patId);
	}
	
	@PostMapping("/notes/{patId}")
	public ResponseEntity<NoteBean> addPatientNote(@PathVariable Integer patId, @RequestBody NoteBean note) throws URISyntaxException{
		return notesProxy.createNote(patId, note);
	}
	
	
	
}
