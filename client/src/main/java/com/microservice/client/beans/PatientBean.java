package com.microservice.client.beans;

public class PatientBean {
	private String id;
	private String name;
	private String surname;
	private String birthdate;
	private String genre;
	private String address;
	private String telephone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
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
