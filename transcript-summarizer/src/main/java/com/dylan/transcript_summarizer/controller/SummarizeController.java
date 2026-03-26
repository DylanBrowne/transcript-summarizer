package com.dylan.transcript_summarizer.controller;

import com.dylan.transcript_summarizer.dto.SummarizeRequest;
import com.dylan.transcript_summarizer.service.OllamaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SummarizeController {

    private final OllamaService myOllamaService;

    public SummarizeController(OllamaService theOllamaService) {
        super();
        myOllamaService = theOllamaService;
    }

    @PostMapping("/summarize")
    public String summarize(@RequestBody SummarizeRequest request) {
        return myOllamaService.summarize(request);
    }
}
