package com.haidara.profileapi.service;

import com.haidara.profileapi.model.CatFactResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class CatFactService {
    
    private static final Logger logger = LoggerFactory.getLogger(CatFactService.class);
    
    private final RestTemplate restTemplate;
    private final Random random = new Random();
    
    @Value("${app.cat-fact.api-url}")
    private String catFactApiUrl;
    
    // Fallback facts in case the external API fails
    private final List<String> fallbackFacts = Arrays.asList(
        "Cats have been domesticated for around 4,000 years.",
        "A group of cats is called a clowder.",
        "Cats sleep for 70% of their lives.",
        "Cats can rotate their ears 180 degrees.",
        "A cat's nose has a unique pattern, like a human fingerprint."
    );
    
    public CatFactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public String fetchRandomCatFact() {
        try {
            logger.info("Fetching cat fact from: {}", catFactApiUrl);
            
            ResponseEntity<CatFactResponse> response = 
                restTemplate.getForEntity(catFactApiUrl, CatFactResponse.class);
            
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                String fact = response.getBody().getFact();
                logger.info("Successfully fetched cat fact: {}", fact);
                return fact;
            } else {
                throw new RuntimeException("Invalid response from Cat Facts API");
            }
            
        } catch (ResourceAccessException e) {
            logger.warn("Timeout or connection error fetching cat fact: {}", e.getMessage());
            return getRandomFallbackFact();
            
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.warn("HTTP error fetching cat fact: {} - {}", e.getStatusCode(), e.getMessage());
            return getRandomFallbackFact();
            
        } catch (Exception e) {
            logger.error("Unexpected error fetching cat fact: {}", e.getMessage());
            return getRandomFallbackFact();
        }
    }
    
    private String getRandomFallbackFact() {
        String fallbackFact = fallbackFacts.get(random.nextInt(fallbackFacts.size()));
        logger.info("Using fallback cat fact: {}", fallbackFact);
        return fallbackFact;
    }
}
