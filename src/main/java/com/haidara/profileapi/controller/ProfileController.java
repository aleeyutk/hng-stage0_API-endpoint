package com.haidara.profileapi.controller;

import com.haidara.profileapi.model.ProfileResponse;
import com.haidara.profileapi.model.User;
import com.haidara.profileapi.service.CatFactService;
import com.haidara.profileapi.util.LoggingUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ProfileController {
    
    private final CatFactService catFactService;
    private final LoggingUtil loggingUtil;
    
    @Value("${profile.email}")
    private String userEmail;
    
    @Value("${profile.name}")
    private String userName;
    
    @Value("${profile.stack}")
    private String userStack;
    
    public ProfileController(CatFactService catFactService, LoggingUtil loggingUtil) {
        this.catFactService = catFactService;
        this.loggingUtil = loggingUtil;
    }
    
    @GetMapping("/me")
    public ResponseEntity<ProfileResponse> getProfile(HttpServletRequest request) {
        long startTime = System.currentTimeMillis();
        
        // Log the request
        loggingUtil.logRequest("GET", "/api/me", getClientIp(request));
        
        try {
            // Create user profile
            User user = new User(userEmail, userName, userStack);
            
            // Fetch dynamic cat fact
            String catFact = catFactService.fetchRandomCatFact();
            
            // Build response
            ProfileResponse response = ProfileResponse.success(user, catFact);
            
            // Log response time
            loggingUtil.logResponseTime("/api/me", System.currentTimeMillis() - startTime);
            
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(response);
                    
        } catch (Exception e) {
            // Fallback response in case of unexpected errors
            User user = new User(userEmail, userName, userStack);
            ProfileResponse fallbackResponse = ProfileResponse.success(
                user, 
                "Cats are amazing creatures with excellent night vision."
            );
            
            loggingUtil.logResponseTime("/api/me", System.currentTimeMillis() - startTime);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(fallbackResponse);
        }
    }
    
    private String getClientIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader != null) {
            return xfHeader.split(",")[0];
        }
        return request.getRemoteAddr();
    }
}
