package com.example.demo.Controller.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTO {

    private Object response;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("response")
    public Object getResponse() {
        return response;
    }

    public void setTime(Object response) {
        this.response = response;
    }

}
