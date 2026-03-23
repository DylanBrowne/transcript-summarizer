package com.dylan.transcript_summarizer.controller;

import com.dylan.transcript_summarizer.dto.SummarizeRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class SummarizeController {

    private final RestTemplate myRestTemplate;

    public SummarizeController(RestTemplate restTemplate) {
        myRestTemplate = restTemplate;
    }

    @PostMapping("/summarize")
    public String summarize(@RequestBody SummarizeRequest request) {
        return  "Received text with "
                + request.getText().length()
                + " characters.";
    }
}
