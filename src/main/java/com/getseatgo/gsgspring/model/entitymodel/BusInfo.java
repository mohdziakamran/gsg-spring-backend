package com.getseatgo.gsgspring.model.entitymodel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BusInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String busName;
    private String busNumber;
    private Integer totalSeat;
    //private Long agencyId;
    @ManyToOne (fetch = FetchType.LAZY)
    private AgencyInfo agency;
    
    
	public BusInfo() {
		super();
	}
	public BusInfo(String busName, String busNumber, Integer totalSeat, AgencyInfo agency) {
		super();
		this.busName = busName;
		this.busNumber = busNumber;
		this.totalSeat = totalSeat;
		this.agency = agency;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public Integer getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(Integer totalSeat) {
		this.totalSeat = totalSeat;
	}
	public AgencyInfo getAgency() {
		return agency;
	}
	public void setAgency(AgencyInfo agency) {
		this.agency = agency;
	}
    
}
