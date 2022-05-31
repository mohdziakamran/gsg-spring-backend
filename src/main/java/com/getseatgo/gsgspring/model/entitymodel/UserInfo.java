package com.getseatgo.gsgspring.model.entitymodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //Common Details
    @Column(unique = true)
    private String username;
    private String password;
    private String fullname;
    //Agent Details (NULL for AppUser)
    private Long agencyId=null;
    //AppUser Details (NULL for Agent User)
    private String email;
    private String phone;
    private boolean isactive=false;
    //Address Details
	private String houseStreet;
	private String city;
	private String pincode;
	private String country;
	private String state;
    
    //constructor
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserInfo(String username, String password, String fullname, Long agencyId, String email, String phone,
			boolean isactive, String houseStreet, String city, String pincode, String country, String state) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.agencyId = agencyId;
		this.email = email;
		this.phone = phone;
		this.isactive = isactive;
		this.houseStreet = houseStreet;
		this.city = city;
		this.pincode = pincode;
		this.country = country;
		this.state = state;
	}

	//getters setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public Long getAgencyId() {
		return agencyId;
	}


	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isIsactive() {
		return isactive;
	}


	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
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
