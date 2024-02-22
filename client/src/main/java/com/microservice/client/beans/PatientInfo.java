package com.microservice.client.beans;

import java.util.List;

public class PatientInfo {
	private PatientBean patient;
	private List<NoteBean> notes; 
	
	public PatientInfo(PatientBean patient, List<NoteBean> patientNote) {
		this.patient = patient;
		this.notes = patientNote;
	}

	public PatientBean getPatient() {
		return patient;
	}

	public void setPatient(PatientBean patient) {
		this.patient = patient;
	}

	public List<NoteBean> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteBean> notes) {
		this.notes = notes;
	}
	
	
}
