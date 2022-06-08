
package com.getseatgo.gsgspring.model;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "busStop",
    "fares",
    "travelDuration"
})
@Generated("jsonschema2pojo")
public class BusRoute {

    @JsonProperty("busStop")
    private String busStop;
    @JsonProperty("fares")
    private List<Double> fares = null;
    @JsonProperty("travelDuration")
    private String travelDuration;

    @JsonProperty("busStop")
    public String getBusStop() {
        return busStop;
    }

    @JsonProperty("busStop")
    public void setBusStop(String busStop) {
        this.busStop = busStop;
    }

    @JsonProperty("fares")
    public List<Double> getFares() {
        return fares;
    }

    @JsonProperty("fares")
    public void setFares(List<Double> fares) {
        this.fares = fares;
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
