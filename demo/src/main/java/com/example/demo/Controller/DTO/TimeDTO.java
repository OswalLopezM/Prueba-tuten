package com.example.demo.Controller.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeDTO {

    private String time;
    private String timeZone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("timezone")
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

}
