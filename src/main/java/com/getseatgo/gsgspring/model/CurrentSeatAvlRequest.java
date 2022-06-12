package com.getseatgo.gsgspring.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "bus_id", "date", "source", "destination" })
public class CurrentSeatAvlRequest implements Serializable {

	@JsonProperty("bus_id")
	private String busId;
	@JsonProperty("date")
	private String date;
	@JsonProperty("source")
	private String source;
	@JsonProperty("destination")
	private String destination;
	private final static long serialVersionUID = 8691582116333345937L;

	@JsonProperty("bus_id")
	public String getBusId() {
		return busId;
	}

	@JsonProperty("bus_id")
	public void setBusId(String busId) {
		this.busId = busId;
	}

	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
	}

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

}