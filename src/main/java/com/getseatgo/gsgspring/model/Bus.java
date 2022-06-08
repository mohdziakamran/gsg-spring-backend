
package com.getseatgo.gsgspring.model;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "busName",
    "busNumber",
    "totalSeat",
    "startBusStop",
    "departureTime",
    "busRoutes",
    "sunday",
    "monday",
    "tuesday",
    "wednesday",
    "thursday",
    "friday",
    "saturday"
})
@Generated("jsonschema2pojo")
public class Bus {

    @JsonProperty("busName")
    private String busName;
    @JsonProperty("busNumber")
    private String busNumber;
    @JsonProperty("totalSeat")
    private Integer totalSeat;
    @JsonProperty("startBusStop")
    private String startBusStop;
    @JsonProperty("departureTime")
    private String departureTime;
    @JsonProperty("busRoutes")
    private List<BusRoute> busRoutes = null;
    @JsonProperty("sunday")
    private Boolean sunday;
    @JsonProperty("monday")
    private Boolean monday;
    @JsonProperty("tuesday")
    private Boolean tuesday;
    @JsonProperty("wednesday")
    private Boolean wednesday;
    @JsonProperty("thursday")
    private Boolean thursday;
    @JsonProperty("friday")
    private Boolean friday;
    @JsonProperty("saturday")
    private Boolean saturday;

    @JsonProperty("busName")
    public String getBusName() {
        return busName;
    }

    @JsonProperty("busName")
    public void setBusName(String busName) {
        this.busName = busName;
    }

    @JsonProperty("busNumber")
    public String getBusNumber() {
        return busNumber;
    }

    @JsonProperty("busNumber")
    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    @JsonProperty("totalSeat")
    public Integer getTotalSeat() {
        return totalSeat;
    }

    @JsonProperty("totalSeat")
    public void setTotalSeat(Integer totalSeat) {
        this.totalSeat = totalSeat;
    }

    @JsonProperty("startBusStop")
    public String getStartBusStop() {
        return startBusStop;
    }

    @JsonProperty("startBusStop")
    public void setStartBusStop(String startBusStop) {
        this.startBusStop = startBusStop;
    }

    @JsonProperty("departureTime")
    public String getDepartureTime() {
        return departureTime;
    }

    @JsonProperty("departureTime")
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @JsonProperty("busRoutes")
    public List<BusRoute> getBusRoutes() {
        return busRoutes;
    }

    @JsonProperty("busRoutes")
    public void setBusRoutes(List<BusRoute> busRoutes) {
        this.busRoutes = busRoutes;
    }

    @JsonProperty("sunday")
    public Boolean getSunday() {
        return sunday;
    }

    @JsonProperty("sunday")
    public void setSunday(Boolean sunday) {
        this.sunday = sunday;
    }

    @JsonProperty("monday")
    public Boolean getMonday() {
        return monday;
    }

    @JsonProperty("monday")
    public void setMonday(Boolean monday) {
        this.monday = monday;
    }

    @JsonProperty("tuesday")
    public Boolean getTuesday() {
        return tuesday;
    }

    @JsonProperty("tuesday")
    public void setTuesday(Boolean tuesday) {
        this.tuesday = tuesday;
    }

    @JsonProperty("wednesday")
    public Boolean getWednesday() {
        return wednesday;
    }

    @JsonProperty("wednesday")
    public void setWednesday(Boolean wednesday) {
        this.wednesday = wednesday;
    }

    @JsonProperty("thursday")
    public Boolean getThursday() {
        return thursday;
    }

    @JsonProperty("thursday")
    public void setThursday(Boolean thursday) {
        this.thursday = thursday;
    }

    @JsonProperty("friday")
    public Boolean getFriday() {
        return friday;
    }

    @JsonProperty("friday")
    public void setFriday(Boolean friday) {
        this.friday = friday;
    }

    @JsonProperty("saturday")
    public Boolean getSaturday() {
        return saturday;
    }

    @JsonProperty("saturday")
    public void setSaturday(Boolean saturday) {
        this.saturday = saturday;
    }

}
