package com.dylan.transcript_summarizer.controller;

import com.dylan.transcript_summarizer.dto.SummarizeRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SummarizeController {

    @PostMapping("/summarize")
    public String summarize(@RequestBody SummarizeRequest request) {
        return  "Received text with "
                + request.getText().length()
                + " characters.";
    }
}
