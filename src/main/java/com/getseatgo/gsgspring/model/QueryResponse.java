
package com.getseatgo.gsgspring.model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "result"
})
@Generated("jsonschema2pojo")
public class QueryResponse implements Serializable
{

    @JsonProperty("result")
    private List<Result> result = null;
    private final static long serialVersionUID = -2269451428969856362L;

    @JsonProperty("result")
    public List<Result> getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(List<Result> result) {
        this.result = result;
    }

}
