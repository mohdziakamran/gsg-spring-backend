package com.getseatgo.gsgspring.model;

import java.io.Serializable;

public class QueryRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String sourceBusStop;
    private String destinationBusStop;
    //Format dd-MM-YYYY
    private String dateOfJourney;
	public QueryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QueryRequest(String sourceBusStop, String destinationBusStop, String dateOfJourney) {
		super();
		this.sourceBusStop = sourceBusStop;
		this.destinationBusStop = destinationBusStop;
		this.dateOfJourney = dateOfJourney;
	}
	public String getSourceBusStop() {
		return sourceBusStop;
	}
	public void setSourceBusStop(String sourceBusStop) {
		this.sourceBusStop = sourceBusStop;
	}
	public String getDestinationBusStop() {
		return destinationBusStop;
	}
	public void setDestinationBusStop(String destinationBusStop) {
		this.destinationBusStop = destinationBusStop;
	}
	public String getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
    
    

}
