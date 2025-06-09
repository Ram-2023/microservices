package com.microservices.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling message-related endpoints.
 * This controller demonstrates the usage of configuration properties that can
 * be refreshed at runtime.
 */
@RestController
@RequestMapping("/v1/messages")
@RefreshScope // Enables dynamic reloading of configuration properties
public class MessageController {

    /**
     * Message property injected from configuration.
     * The value is fetched from the 'spring.message' configuration property.
     */
    @Value("${spring.message}")
    private String message;

    /**
     * Retrieves the configured message.
     *
     * @return The message configured through the 'spring.message' property
     */
    @GetMapping
    public String getMessage() {
        return message;
    }
}
