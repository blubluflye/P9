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
		String words = "Hémoglobine,Microalbumine,Taille,Poids,Fume,Anormal,Cholestérol,Vertige,Rechute,Réaction,Anticorps";
		List<String> wordToCheck = Arrays.asList(words.toLowerCase().split(","));
		System.out.println(wordToCheck.toString());
		Boolean markerCheckList[] = new Boolean[wordToCheck.size()];
		Arrays.fill(markerCheckList, false);
		for (NoteBean note : patientInfo.getNotes()) {
			List<String> noteWordArray = Arrays.asList(note.getNote().toLowerCase().split("\\P{L}+"));
			for (int j = 0; j < noteWordArray.size(); j++) {
				for (int i = 0 ;i<wordToCheck.size(); i++) {
					if (noteWordArray.get(j).contains(wordToCheck.get(i))) {
						if (i == 1) {
							if (j < noteWordArray.size()-1 && noteWordArray.get(j+1).contains("a1c"))
								markerCheckList[i]=true;
						}
						else
							markerCheckList[i]=true;
					}
				}
			}
		}
		for (Boolean marker : markerCheckList)
			if (marker == true)
				count++;
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
