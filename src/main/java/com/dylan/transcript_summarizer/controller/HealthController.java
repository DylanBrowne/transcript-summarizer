package com.dylan.transcript_summarizer.controller;

import org.springframework.web.bind.annotation.*;

/**
 * REST controller responsible for handling HTTP requests related to the application.
 *<p>
 * This class defines API endpoints that process incoming client requests,
 * delegate business logic to the appropriate services, and return responses
 * to the client in JSON or text format.
 *<p>
 * Controllers act as the entry point of the backend application,
 * connecting external HTTP requests to internal application logic.
 */
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
