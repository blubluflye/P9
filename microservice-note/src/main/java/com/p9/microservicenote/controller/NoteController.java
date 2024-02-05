package com.p9.microservicenote.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.p9.microservicenote.model.Note;
import com.p9.microservicenote.repository.NoteRepository;

@RestController
public class NoteController {

	@Autowired
	private NoteRepository notes;
	
	@GetMapping("/notes{id}")
	public List<Note> getPatientNote(@PathVariable Integer id) {
		return notes.findByPatId(id);
	}
	
	@PostMapping("/notes{patId}")
	public ResponseEntity<Note> createNote(@PathVariable Integer patId, @RequestBody Note note) throws URISyntaxException{
		note.setPatId(patId);
		Note savedNote = notes.save(note);
		return ResponseEntity.created(new URI("/notes" + savedNote.getId())).body(savedNote);
	}
}
