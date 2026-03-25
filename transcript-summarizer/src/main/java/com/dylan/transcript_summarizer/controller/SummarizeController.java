package com.dylan.transcript_summarizer.controller;

import com.dylan.transcript_summarizer.dto.OllamaRequest;
import com.dylan.transcript_summarizer.dto.OllamaResponse;
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
        OllamaRequest ollamaRequest = new OllamaRequest();

        //curl.exe -X POST http://localhost:8080/api/summarize
        // -H "Content-Type: application/json"
        // -d "{\"text\":\"This is text to be sent to Ollama\",\"maxLength\":50}"
        ollamaRequest.setPrompt("Summarize: " + request.getText());
        ollamaRequest.setModel("llama3.1");
        ollamaRequest.setStream(false);

        OllamaResponse response = myRestTemplate.postForObject(
                "http://localhost:11434/api/generate", //Ollama's URL
                ollamaRequest, //OllamaRequest object
                OllamaResponse.class //Convert JSON to this class
        );

        return  response.getResponse();
    }
}
