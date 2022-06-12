package com.getseatgo.gsgspring.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"avl_seats"
})
public class CurrentSeatAvlResponse implements Serializable
{

@JsonProperty("avl_seats")
private Integer avlSeats;
private final static long serialVersionUID = 7670081920562071965L;

@JsonProperty("avl_seats")
public Integer getAvlSeats() {
return avlSeats;
}

@JsonProperty("avl_seats")
public void setAvlSeats(Integer avlSeats) {
this.avlSeats = avlSeats;
}

}