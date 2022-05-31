package com.getseatgo.gsgspring.model.entitymodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AgencyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String agencyName;
    private String contactDetails;
    private String bankDetails;
    
    //Address Details
	private String houseStreet;
	private String city;
	private String pincode;
	private String country;
	private String state;
	
	public AgencyInfo() {
		super();
	}

	public AgencyInfo(String agencyName, String contactDetails, String bankDetails, String houseStreet, String city,
			String pincode, String country, String state) {
		super();
		this.agencyName = agencyName;
		this.contactDetails = contactDetails;
		this.bankDetails = bankDetails;
		this.houseStreet = houseStreet;
		this.city = city;
		this.pincode = pincode;
		this.country = country;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
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
