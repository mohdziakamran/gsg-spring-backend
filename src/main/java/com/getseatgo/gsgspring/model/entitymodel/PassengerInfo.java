package com.getseatgo.gsgspring.model.entitymodel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PassengerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //private Long ticketId;
    @ManyToOne (fetch = FetchType.LAZY)
    private TicketInfo ticket;
    private String name;
    private int age;
    private String gender;
	public PassengerInfo() {
		super();
	}
	public PassengerInfo(TicketInfo ticket, String name, int age, String gender) {
		super();
		this.ticket = ticket;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TicketInfo getTicket() {
		return ticket;
	}
	public void setTicket(TicketInfo ticket) {
		this.ticket = ticket;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
    
    
    
}
