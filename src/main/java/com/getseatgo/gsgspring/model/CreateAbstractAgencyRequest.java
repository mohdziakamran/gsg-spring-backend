
package com.getseatgo.gsgspring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "eamil"
})
public class CreateAbstractAgencyRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("eamil")
    private String eamil;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("eamil")
    public String getEamil() {
        return eamil;
    }

    @JsonProperty("eamil")
    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

}
