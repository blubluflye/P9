package com.p9.microservicetestdiabete.beans;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

public class PatientInfo {

	private PatientBean patient;
	private List<NoteBean> notes;
	


	public PatientInfo() {
		super();
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



	public long getAge() {
		if (patient.getBirthdate() == null)
			return 30;
		return patient.getBirthdate().until(LocalDate.now(), ChronoUnit.YEARS);
	}
	
	

}
