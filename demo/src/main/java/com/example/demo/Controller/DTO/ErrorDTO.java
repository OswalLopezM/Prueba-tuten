package com.example.demo.Controller.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDTO {
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("time")
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
