package com.aphelion.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sol {

    @JsonProperty("AT")
    private AtmosTemp temp;
    @JsonProperty("HWS")
    private WindSpeed windSpeed;
    @JsonProperty("PRE")
    private AtmosPress pressure;
    @JsonProperty("Season")
    private String season;
    @JsonProperty("First_UTC")
    private String firstUTC;
    @JsonProperty("Last_UTC")
    private String lastUTC;

    public String getSeason() {
        if (season != null)
            return season;
        else
            return "*Missing*";
    }

    public String getFirstUTC() {
        if (firstUTC != null)
            return firstUTC.substring(0, 10);
        else
            return "*Missing*";
    }

    public String getLastUTC() {
        return lastUTC;
    }

    public AtmosTemp getTemp() {
        return temp;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    public AtmosPress getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return
                "{" + "\n"
                + "\t\tSeason: " + season + "\n"
                + "\t\tFirst_UTC: " + firstUTC + "\n"
                + "\t\tLast_UTC: " + lastUTC + "\n"
                + "\t}\n";
    }
}
