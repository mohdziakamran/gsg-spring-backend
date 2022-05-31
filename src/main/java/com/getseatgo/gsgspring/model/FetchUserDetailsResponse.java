package com.getseatgo.gsgspring.model;

import java.io.Serializable;

public class FetchUserDetailsResponse implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String firstname;
    private String lastname;
    private String phone;
    private Address address;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public FetchUserDetailsResponse() {
		super();
	}
	public FetchUserDetailsResponse(String firstname, String lastname, String phone, Address address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
	}
    
    
    
    

}
