package com.p9.microservicenote.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.p9.microservicenote.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String>{
	List<Note> findByName(String name);

	List<Note> findByPatId(Integer patId);
}
