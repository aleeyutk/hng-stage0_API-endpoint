package com.haidara.profileapi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingUtil.class);
    
    public void logRequest(String method, String path, String clientIp) {
        logger.info("{} {} - {}", method, path, clientIp);
    }
    
    public void logResponseTime(String path, long duration) {
        logger.debug("{} completed in {}ms", path, duration);
    }
}
