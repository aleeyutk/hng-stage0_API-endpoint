package com.haidara.profileapi.model;

public class User {
    private final String email;
    private final String name;
    private final String stack;
    
    public User(String email, String name, String stack) {
        this.email = email;
        this.name = name;
        this.stack = stack;
    }
    
    // Getters
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getStack() { return stack; }
}
