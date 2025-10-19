package com.haidara.profileapi.model;

import java.time.Instant;

public class ProfileResponse {
    private final String status;
    private final User user;
    private final String timestamp;
    private final String fact;
    
    public ProfileResponse(String status, User user, String timestamp, String fact) {
        this.status = status;
        this.user = user;
        this.timestamp = timestamp;
        this.fact = fact;
    }
    
    // Getters
    public String getStatus() { return status; }
    public User getUser() { return user; }
    public String getTimestamp() { return timestamp; }
    public String getFact() { return fact; }
    
    // Builder pattern for easier construction
    public static ProfileResponse success(User user, String fact) {
        return new ProfileResponse(
            "success",
            user,
            Instant.now().toString(), // ISO 8601 format
            fact
        );
    }
}
