package com.haidara.profileapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatFactResponse {
    private String fact;
    private int length;
    
    // Default constructor for Jackson
    public CatFactResponse() {}
    
    public CatFactResponse(String fact, int length) {
        this.fact = fact;
        this.length = length;
    }
    
    // Getters and Setters
    public String getFact() { return fact; }
    public void setFact(String fact) { this.fact = fact; }
    
    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }
}
