package com.getseatgo.gsgspring.model.entitymodel;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BusDateSeatAvailabilityInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date journeyDate;
    //private Long busRouteId;
    @ManyToOne (fetch = FetchType.LAZY)
    private BusRouteInfo busRoute;
    private int seatAvailable;
    
    
	public BusDateSeatAvailabilityInfo() {
		super();
	}
	public BusDateSeatAvailabilityInfo(Date journeyDate, BusRouteInfo busRoute, int seatAvailable) {
		super();
		this.journeyDate = journeyDate;
		this.busRoute = busRoute;
		this.seatAvailable = seatAvailable;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public BusRouteInfo getBusRoute() {
		return busRoute;
	}
	public void setBusRoute(BusRouteInfo busRoute) {
		this.busRoute = busRoute;
	}
	public int getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
    
}
