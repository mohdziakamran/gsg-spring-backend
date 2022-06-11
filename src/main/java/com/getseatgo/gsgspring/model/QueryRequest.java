package com.getseatgo.gsgspring.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "source", "destination", "date_of_journey" })
public class QueryRequest implements Serializable {

	@JsonProperty("source")
	private String source;
	@JsonProperty("destination")
	private String destination;
	@JsonProperty("date_of_journey")
	private String dateOfJourney;
	private final static long serialVersionUID = -253723775822213392L;

	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	@JsonProperty("source")
	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("destination")
	public String getDestination() {
		return destination;
	}

	@JsonProperty("destination")
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@JsonProperty("date_of_journey")
	public String getDateOfJourney() {
		return dateOfJourney;
	}

	@JsonProperty("date_of_journey")
	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

}