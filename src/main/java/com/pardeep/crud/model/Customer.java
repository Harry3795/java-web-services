package com.pardeep.crud.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
	private int custId;
	private String fname;
	private String lname;
	@Size(max=10,message="Please provide 10 digit valid phone number")
	@Pattern(regexp = "^[\\+]?[(]?[6-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
	private long contact;
	
	private String email;

	

	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getFname() {
		return this.fname;
	}
//	@NotBlank(message="Please provide name!")
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return this.lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public long getContact() {
		return this.contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return this.email;
	}
	@NotBlank(message="Please provide email!")
	@Email(message="Please provide valid email id!")
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", fname=" + fname + ", lname=" + lname + ", contact=" + contact
				+ ", email=" + email + "]";
	}
	

	
	
}
