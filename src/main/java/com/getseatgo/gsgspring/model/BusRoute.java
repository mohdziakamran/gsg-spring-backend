
package com.getseatgo.gsgspring.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startBusStop",
    "endBusStop",
    "fare",
    "departureTime",
    "travelDuration"
})
@Generated("jsonschema2pojo")
public class BusRoute {

    @JsonProperty("startBusStop")
    private String startBusStop;
    @JsonProperty("endBusStop")
    private String endBusStop;
    @JsonProperty("fare")
    private String fare;
    //HH:MM:SS
    @JsonProperty("departureTime")
    private String departureTime;
    //HH:MM:SS
    @JsonProperty("travelDuration")
    private String travelDuration;

    @JsonProperty("startBusStop")
    public String getStartBusStop() {
        return startBusStop;
    }

    @JsonProperty("startBusStop")
    public void setStartBusStop(String startBusStop) {
        this.startBusStop = startBusStop;
    }

    @JsonProperty("endBusStop")
    public String getEndBusStop() {
        return endBusStop;
    }

    @JsonProperty("endBusStop")
    public void setEndBusStop(String endBusStop) {
        this.endBusStop = endBusStop;
    }

    @JsonProperty("fare")
    public String getFare() {
        return fare;
    }

    @JsonProperty("fare")
    public void setFare(String fare) {
        this.fare = fare;
    }

    @JsonProperty("departureTime")
    public String getDepartureTime() {
        return departureTime;
    }

    @JsonProperty("departureTime")
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @JsonProperty("travelDuration")
    public String getTravelDuration() {
        return travelDuration;
    }

    @JsonProperty("travelDuration")
    public void setTravelDuration(String travelDuration) {
        this.travelDuration = travelDuration;
    }

}
