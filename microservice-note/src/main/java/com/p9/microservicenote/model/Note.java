package com.p9.microservicenote.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Note {
	@Id
	String id;
	Integer patId;
	String name;
	String note;
	
	public Integer getPatId() {
		return patId;
	}
	public void setPatId(Integer patId) {
		this.patId = patId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getId() {
		return id;
	}
	
	
}
