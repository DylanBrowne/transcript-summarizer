package com.dylan.transcript_summarizer.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HealthController {

    /**
     * Health check endpoint.
     * Handles the HTTP GET request for the /health endpoint.
     *
     * @return the server status
     */
    @GetMapping("/health")
    public String getServerHealth() {
        return "Server is running!";
    }



}
