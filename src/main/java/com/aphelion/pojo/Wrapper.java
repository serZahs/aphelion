package com.aphelion.pojo;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wrapper {

    private Map<String, Sol> solInfo = new HashMap<>();
    @JsonProperty("sol_keys")
    private List<String> solKeys;

    @JsonAnySetter
    public void setSol_info(String k, Sol v) {
        solInfo.put(k, v);
    }

    public Sol getSol(String s) {
        return solInfo.get(s);
    }

    public List<String> getSolKeys() {
        return solKeys;
    }

    @Override
    public String toString() {
        return "";
    }
}
