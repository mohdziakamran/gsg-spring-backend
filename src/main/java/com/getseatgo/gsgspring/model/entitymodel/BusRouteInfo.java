package com.getseatgo.gsgspring.model.entitymodel;

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
    private Double fare;
    private Long departureTimeInSec;
    private Long travelDurationInSec;
    private String routeSeq;
//    @ManyToOne (fetch = FetchType.LAZY)
//    private BusWeeklySchedule busWeeklySchedule;
    
//	public BusWeeklySchedule getBusWeeklySchedule() {
//		return busWeeklySchedule;
//	}
//	public void setBusWeeklySchedule(BusWeeklySchedule busWeeklySchedule) {
//		this.busWeeklySchedule = busWeeklySchedule;
//	}
	public Long getDepartureTimeInSec() {
		return departureTimeInSec;
	}
	public void setDepartureTimeInSec(Long departureTimeInSec) {
		this.departureTimeInSec = departureTimeInSec;
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
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public Long getTravelDurationInSec() {
		return travelDurationInSec;
	}
	public void setTravelDurationInSec(Long travelDurationInSec) {
		this.travelDurationInSec = travelDurationInSec;
	}
	public String getRouteSeq() {
		return routeSeq;
	}
	public void setRouteSeq(String routeSeq) {
		this.routeSeq = routeSeq;
	}
    
}
