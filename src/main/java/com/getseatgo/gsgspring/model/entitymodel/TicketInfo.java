package com.getseatgo.gsgspring.model.entitymodel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TicketInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //private Long userId;
    @ManyToOne (fetch = FetchType.LAZY)
    private UserInfo user;
    //private Long busId;
    @ManyToOne (fetch = FetchType.LAZY)
    private BusInfo bus;
    private Date bookingDateTime;
    //private Long startBusStopId;
    @ManyToOne (fetch = FetchType.LAZY)
    private BusStop startBusStop;
    //private Long endBusStopId;
    @ManyToOne (fetch = FetchType.LAZY)
    private BusStop endBusStop;
    private float totalFare;
    private Date departureDateTime;
    private Date arrivalDateTime;
	public TicketInfo() {
		super();
	}
	public TicketInfo(UserInfo user, BusInfo bus, Date bookingDateTime, BusStop startBusStop, BusStop endBusStop,
			float totalFare, Date departureDateTime, Date arrivalDateTime) {
		super();
		this.user = user;
		this.bus = bus;
		this.bookingDateTime = bookingDateTime;
		this.startBusStop = startBusStop;
		this.endBusStop = endBusStop;
		this.totalFare = totalFare;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public BusInfo getBus() {
		return bus;
	}
	public void setBus(BusInfo bus) {
		this.bus = bus;
	}
	public Date getBookingDateTime() {
		return bookingDateTime;
	}
	public void setBookingDateTime(Date bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
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
	public float getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(float totalFare) {
		this.totalFare = totalFare;
	}
	public Date getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public Date getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(Date arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
    
    
}
