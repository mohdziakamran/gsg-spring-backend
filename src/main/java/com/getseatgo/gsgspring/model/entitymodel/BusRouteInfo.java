package com.getseatgo.gsgspring.model.entitymodel;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BusRouteInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //private Long busId;
    @ManyToOne (fetch = FetchType.LAZY)
    private BusInfo bus;
    //private Long startBusStopId;
    @ManyToOne (fetch = FetchType.LAZY)
    private BusStop startBusStop; 
    //private Long endBusStopId;
    @ManyToOne (fetch = FetchType.LAZY)
    private BusStop endBusStop;
    private Float fare;
    private Time departureTime;
    private Long travelDurationInSec;
	public BusRouteInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusRouteInfo(BusInfo bus, BusStop startBusStop, BusStop endBusStop, Float fare, Time departureTime,
			Long travelDurationInSec) {
		super();
		this.bus = bus;
		this.startBusStop = startBusStop;
		this.endBusStop = endBusStop;
		this.fare = fare;
		this.departureTime = departureTime;
		this.travelDurationInSec = travelDurationInSec;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BusInfo getBus() {
		return bus;
	}
	public void setBus(BusInfo bus) {
		this.bus = bus;
	}
	public BusStop getStartBusStop() {
		return startBusStop;
	}
	public void setStartBusStop(BusStop startBusStop) {
		this.startBusStop = startBusStop;
	}
	public BusStop getEndBusStop() {
		return endBusStop;
	}
	public void setEndBusStop(BusStop endBusStop) {
		this.endBusStop = endBusStop;
	}
	public Float getFare() {
		return fare;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public Long getTravelDurationInSec() {
		return travelDurationInSec;
	}
	public void setTravelDurationInSec(Long travelDurationInSec) {
		this.travelDurationInSec = travelDurationInSec;
	}
    
    
    
}
