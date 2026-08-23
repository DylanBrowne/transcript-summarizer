package com.dylan.transcript_summarizer.controller;

import com.dylan.transcript_summarizer.dto.SummarizeRequest;
import com.dylan.transcript_summarizer.service.OllamaService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
/* 
*  This controller class handles HTTP requests related to summarizing text or 
*  content from a URL. It uses the OllamaService to perform the summarization. 
*/
public class SummarizeController {

    private final OllamaService myOllamaService;

    /*
    * Constructor for the SummarizeController class. It takes an OllamaService
    * object as a parameter, which is used to perform the summarization.
    */
    public SummarizeController(OllamaService theOllamaService) {
        super();
        myOllamaService = theOllamaService;
    }

    /*
    * This method handles POST requests to the /api/summarize endpoint. It 
    * takes a SummarizeRequest object as input and returns a summarized 
    * version of the content.
    */
    @PostMapping("/summarize")
    public String summarize(@RequestBody SummarizeRequest request) {
        String response = myOllamaService.summarize(request);
        // Ensure the response does not exceed the maximum word count specified in the request
        if (request.getMaxWords() != null && response != null) {
            String[] words = response.trim().split("\\s+");
            if (words.length > request.getMaxWords()) {
                // Join only up to maxWords
                response = String.join(" ", java.util.Arrays.copyOfRange(words, 0, request.getMaxWords()));
            }
        }
        return response;
    }
}
