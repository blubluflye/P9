package com.p9.microservicetestdiabete.beans;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

public record PatientInfo() {

	static private PatientBean patient;
	static private List<NoteBean> notes;
	
	/**
	 * @return the notes
	 */
	public List<NoteBean> getNotes() {
		return notes;
	}
	
	/**
	 * @return the patient
	 */
	public PatientBean getPatient() {
		return patient;
	}

	public long getAge() {
		return patient.getBirthdate().until(LocalDate.now(), ChronoUnit.YEARS);
	}
	
	

}
