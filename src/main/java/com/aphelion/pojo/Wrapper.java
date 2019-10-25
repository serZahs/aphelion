package com.aphelion.pojo;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wrapper {

    private Map<String, Sol> sol_info = new HashMap<>();
    @JsonProperty("sol_keys")
    private List<String> sol_keys;

    @JsonAnySetter
    public void setSol_info(String k, Sol v) {
        sol_info.put(k, v);
    }

    public Sol getSol(String s) {
        return sol_info.get(s);
    }

    public List<String> getSol_keys() {
        return sol_keys;
    }

    @Override
    public String toString() {
        return "\n{" + "\n"
                + "\t314: " + sol_info.get("314").toString()
                + "\t315: " + sol_info.get("315").toString()
                + "\t316: " + sol_info.get("316").toString()
                + "\tsol_keys: [" + String.join(",", sol_keys) + "]\n"
                + "}\n";
    }
}
