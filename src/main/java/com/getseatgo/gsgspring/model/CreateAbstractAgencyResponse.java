
package com.getseatgo.gsgspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAbstractAgencyResponse extends CreateAbstractAgencyRequest {

    @JsonProperty("agent")
    private Agent agent;

    @JsonProperty("agent")
    public Agent getAgent() {
        return agent;
    }

    @JsonProperty("agent")
    public void setAgent(Agent agent) {
        this.agent = agent;
    }

	public CreateAbstractAgencyResponse(CreateAbstractAgencyRequest createAbstractAgencyRequest) {
		this.setName(createAbstractAgencyRequest.getName());
		this.setEamil(createAbstractAgencyRequest.getEamil());
		
	}
    

}
