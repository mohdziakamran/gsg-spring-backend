package com.getseatgo.gsgspring.model.entitymodel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BusWeeklySchedule {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne (fetch = FetchType.EAGER)
    private BusRouteInfo route;
    private String day;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    private BusInfo bus;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private BusStop startBusStop;
//    private boolean monday;
//    private boolean tuesday;
//    private boolean wednesday;
//    private boolean thursday;
//    private boolean friday;
//    private boolean saturday;
//    private boolean sunday;
    

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BusRouteInfo getRoute() {
		return route;
	}
	public void setRoute(BusRouteInfo route) {
		this.route = route;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
    
    public BusWeeklySchedule() {
		super();
	}
	public BusWeeklySchedule(BusRouteInfo route, String day) {
		super();
		this.route = route;
		this.day = day;
	}
}
