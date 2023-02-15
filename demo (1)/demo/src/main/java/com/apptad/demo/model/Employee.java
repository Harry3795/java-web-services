package com.apptad.demo.model;

public class Employee {

private String empId;	
private String fname;
private String lname;

private String address;
private String contact;
private String emailId;



public String getFname() {
	return this.fname;
}
public String getLname() {
	return this.lname;
}
public void setFname(String fname) {
	 this.fname=fname;
}
public void setLname(String lname) {
	 this.lname=lname;
}
@Override
public String toString() {
	return this.fname + " "+ this.lname;
}



public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
}
