package com.microservices.employeeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/employee/messages")
@RefreshScope
public class MessageController {

    @Value("${spring.message}")
    private String message;

    @GetMapping
    public String getMessage() {
        return message;
    }
}

