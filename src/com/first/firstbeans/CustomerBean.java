package com.first.firstbeans;

public class CustomerBean {
	String firstName;
	String lastName;
	String DateofBirth;
	String SSN;
	
	
	
	public CustomerBean(String firstName, String lastName, String dateofBirth, String sSN) {
		this.firstName = firstName;
		this.lastName = lastName;
		DateofBirth = dateofBirth;
		SSN = sSN;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateofBirth() {
		return DateofBirth;
	}
	public void setDateofBirth(String dateofBirth) {
		DateofBirth = dateofBirth;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
}
