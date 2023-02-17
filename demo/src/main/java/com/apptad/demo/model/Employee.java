package com.apptad.demo.model;

public class Employee {

private int empId;	
private String fname;
private String lname;

private String address;
private int contact;
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
//tostring----------------------------------------------------------------
@Override
public String toString() {
	return this.fname + " "+ this.lname;
}



public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getContact() {
	return contact;
}
public void setContact(int contact) {
	this.contact = contact;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
}
