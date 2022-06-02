package com.getseatgo.gsgspring.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "phone", "bankDetails", "address" })
@Generated("jsonschema2pojo")
public class UpdateAgencyDetailsRequest {

	@JsonProperty("phone")
	private String phone;
	@JsonProperty("bankDetails")
	private String bankDetails;
	@JsonProperty("address")
	private Address address;

	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonProperty("bankDetails")
	public String getBankDetails() {
		return bankDetails;
	}

	@JsonProperty("bankDetails")
	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(Address address) {
		this.address = address;
	}

	public UpdateAgencyDetailsRequest() {
		super();
	}

	public UpdateAgencyDetailsRequest(String phone, String bankDetails, Address address) {
		super();
		this.phone = phone;
		this.bankDetails = bankDetails;
		this.address = address;
	}

}