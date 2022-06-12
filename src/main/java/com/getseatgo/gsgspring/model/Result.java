
package com.getseatgo.gsgspring.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bus_id",
    "source",
    "destination",
    "date_of_journey",
    "bus_number",
    "bus_name",
    "agency_name",
    "no_of_seats_available",
    "departure_time",
    "arrival_time",
    "fare_for_one_seat"
})
@Generated("jsonschema2pojo")
public class Result implements Serializable
{

    @JsonProperty("bus_id")
    private String busId;
    @JsonProperty("source")
    private String source;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("date_of_journey")
    private String dateOfJourney;
    @JsonProperty("bus_number")
    private String busNumber;
    @JsonProperty("bus_name")
    private String busName;
    @JsonProperty("agency_name")
    private String agencyName;
    @JsonProperty("no_of_seats_available")
    private Integer noOfSeatsAvailable;
    @JsonProperty("departure_time")
    private String departureTime;
    @JsonProperty("arrival_time")
    private String arrivalTime;
    @JsonProperty("fare_for_one_seat")
    private Double fareForOneSeat;
    private final static long serialVersionUID = 6598718005984486971L;

    @JsonProperty("bus_id")
    public String getBusId() {
        return busId;
    }

    @JsonProperty("bus_id")
    public void setBusId(String busId) {
        this.busId = busId;
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

    @JsonProperty("date_of_journey")
    public String getDateOfJourney() {
        return dateOfJourney;
    }

    @JsonProperty("date_of_journey")
    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    @JsonProperty("bus_number")
    public String getBusNumber() {
        return busNumber;
    }

    @JsonProperty("bus_number")
    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    @JsonProperty("bus_name")
    public String getBusName() {
        return busName;
    }

    @JsonProperty("bus_name")
    public void setBusName(String busName) {
        this.busName = busName;
    }

    @JsonProperty("agency_name")
    public String getAgencyName() {
        return agencyName;
    }

    @JsonProperty("agency_name")
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    @JsonProperty("no_of_seats_available")
    public Integer getNoOfSeatsAvailable() {
        return noOfSeatsAvailable;
    }

    @JsonProperty("no_of_seats_available")
    public void setNoOfSeatsAvailable(Integer noOfSeatsAvailable) {
        this.noOfSeatsAvailable = noOfSeatsAvailable;
    }

    @JsonProperty("departure_time")
    public String getDepartureTime() {
        return departureTime;
    }

    @JsonProperty("departure_time")
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @JsonProperty("arrival_time")
    public String getArrivalTime() {
        return arrivalTime;
    }

    @JsonProperty("arrival_time")
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @JsonProperty("fare_for_one_seat")
    public Double getFareForOneSeat() {
        return fareForOneSeat;
    }

    @JsonProperty("fare_for_one_seat")
    public void setFareForOneSeat(Double fareForOneSeat) {
        this.fareForOneSeat = fareForOneSeat;
    }

}
