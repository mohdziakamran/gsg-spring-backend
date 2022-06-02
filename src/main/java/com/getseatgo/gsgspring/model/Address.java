package com.getseatgo.gsgspring.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "houseStreet", "city", "state", "pincode", "country" })
@Generated("jsonschema2pojo")
public class Address {

	@JsonProperty("houseStreet")
	private String houseStreet;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("pincode")
	private String pincode;
	@JsonProperty("country")
	private String country;

	@JsonProperty("houseStreet")
	public String getHouseStreet() {
		return houseStreet;
	}

	@JsonProperty("houseStreet")
	public void setHouseStreet(String houseStreet) {
		this.houseStreet = houseStreet;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("pincode")
	public String getPincode() {
		return pincode;
	}

	@JsonProperty("pincode")
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	public Address(String houseStreet, String city, String state, String pincode, String country) {
		super();
		this.houseStreet = houseStreet;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
	}

	public Address() {
		super();
	}
	

}