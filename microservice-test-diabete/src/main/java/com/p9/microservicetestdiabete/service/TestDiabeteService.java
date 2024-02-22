package com.p9.microservicetestdiabete.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.p9.microservicetestdiabete.beans.NoteBean;
import com.p9.microservicetestdiabete.beans.PatientInfo;

@Service
public class TestDiabeteService {
	public String testdiabete(PatientInfo patientInfo) {
		int count = 0;
		// initiate list of word to check
		String words = "Hémoglobine A1C,Microalbumine,Taille,Poids,Fumeur,Fumeuse,Anormal,Cholestérol,Vertiges,Rechute,Réaction,Anticorps";
		List<String> wordToCheck = Arrays.asList(words.toLowerCase().split(","));

		// make the count of each instance of word to check in patient notes
		for (NoteBean note : patientInfo.getNotes()) {
			List<String> noteWordArray = Arrays.asList(note.getNote().toLowerCase().split("\\P{L}+"));
			for (String word : noteWordArray) {
				if (wordToCheck.contains(word)) {
					count++;
				}
			}
		}

		// test the count with patient personal information
		if (patientInfo.getAge() >= 30) {
			if (count >= 8)
				return "Early onset";
			if (count >= 6)
				return "In Danger";
			if (count >= 2 && count <= 5)
				return "Borderline";
		}
		if (patientInfo.getPatient().getGenre().equalsIgnoreCase("M")) {
			if (count >= 5)
				return "Early onset";
			if (count >= 3)
				return "In Danger";
		} else {
			if (count >= 7)
				return "Early onset";
			if (count >= 4)
				return "In Danger";
		}
		return "None";
	}
}
