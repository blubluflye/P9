package com.microservice.client.beans;

import java.time.LocalDate;

public class PatientBean {
	private Integer id;
	private String name;
	private String surname;
	private LocalDate birthdate;
	private String genre;
	private String address;
	private String telephone;
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	 @Override
	 public String toString() 
	{
	    return "PatientBean{" +
	      "id=" + id +
	      ", name='" + name + '\'' +
	      ", surname='" + surname + '\'' +
	      ", birthdate='" + birthdate + '\'' +
	      ", genre='" + genre + '\'' +
	      ", address='" + address + '\'' +
	      ", telephone='" + telephone  +
	          '}';
	 }
}
