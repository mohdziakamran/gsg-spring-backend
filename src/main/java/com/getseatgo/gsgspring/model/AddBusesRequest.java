
package com.getseatgo.gsgspring.model;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buses"
})
@Generated("jsonschema2pojo")
public class AddBusesRequest {

    @JsonProperty("buses")
    private List<Bus> buses = null;

    @JsonProperty("buses")
    public List<Bus> getBuses() {
        return buses;
    }

    @JsonProperty("buses")
    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

}
