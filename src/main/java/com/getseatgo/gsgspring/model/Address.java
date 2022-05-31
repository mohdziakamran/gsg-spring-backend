package com.getseatgo.gsgspring.model;

import java.io.Serializable;

public class Address  implements Serializable {
	
	private static final long serialVersionUID = 5926468583005150707L;
	private String houseStreet;
	private String city;
	private String pincode;
	private String country;
	private String state;
	public Address(String houseStreet, String city, String pincode, String country, String state) {
		super();
		this.houseStreet = houseStreet;
		this.city = city;
		this.pincode = pincode;
		this.country = country;
		this.state = state;
	}
	public Address() {
		super();
	}
	public String getHouseStreet() {
		return houseStreet;
	}
	public void setHouseStreet(String houseStreet) {
		this.houseStreet = houseStreet;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
