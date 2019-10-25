package com.aphelion.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindSpeed {

    @JsonProperty("mn")
    private int min = -1;
    @JsonProperty("mx")
    private int max = -1;
    @JsonProperty("av")
    private int avg = -1;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getAvg() {
        return avg;
    }
}
