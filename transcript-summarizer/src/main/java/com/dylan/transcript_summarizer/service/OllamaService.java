package com.dylan.transcript_summarizer.service;

import com.dylan.transcript_summarizer.dto.OllamaRequest;
import com.dylan.transcript_summarizer.dto.OllamaResponse;
import com.dylan.transcript_summarizer.dto.SummarizeRequest;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/*
* This service class is responsible for interacting with the Ollama API to 
* summarize text or content from a URL.
*/
@Service
public class OllamaService {
    
    private final RestTemplate myRestTemplate;

    /*
     * Constructor for the OllamaService class. It takes a RestTemplate object 
     * as a parameter, which is used to make HTTP requests to the Ollama API.
     */
    public OllamaService(final RestTemplate theRestTemplate) {
        super();
        myRestTemplate = theRestTemplate;
    }

    /*
    * This method takes a SummarizeRequest object, which may contain either
    * text or a URL, and returns a summarized version of the content.
    */
    public String summarize(SummarizeRequest theRequest) {
        if (theRequest.getText() == null && theRequest.getUrl() == null) {
            throw new IllegalArgumentException("The text or URL fields must 
                                                have a value.");
        }

        String combinedText = "";

        //If URL is provided, use the URL for summarization:
        if (theRequest.getUrl() != null) {
            try {
                combinedText += Jsoup.connect(theRequest.getUrl()).get().text();
            } catch (IOException e) {
                throw new RuntimeException("Failed to fetch URL: " + theRequest.getUrl(), e);
            }

        }

        if (theRequest.getText() != null) {
            combinedText += theRequest.getText();
        }

        OllamaRequest ollamaRequest = getOllamaRequest(combinedText, theRequest.getMaxWords());
        
        try {
            OllamaResponse response = myRestTemplate.postForObject(
                    "http://localhost:11434/api/generate", //Ollama's URL
                    ollamaRequest, //OllamaRequest object
                    OllamaResponse.class //Convert JSON to this class
            );
            if (response == null) {
                throw new IllegalStateException("No response from Ollama.");
            }

            return response.getResponse();

            //Handle if Ollama is unavailable:
        } catch (ResourceAccessException e) {
            throw new RuntimeException("Ollama is unavailable. Is it running?", e);
        }
    }

    /*
    * This method constructs an OllamaRequest object based on the provided 
    * text and optional summary length.
    */
    private static OllamaRequest getOllamaRequest(String theCombinedText, Integer theSummaryLength) {

        
        OllamaRequest ollamaRequest = new OllamaRequest();

        //curl.exe -X POST http://localhost:8080/api/summarize
        // -H "Content-Type: application/json"
        // -d "{\"text\":\"This is text to be sent to Ollama\",\"maxLength\":50}"

        //Check if the length field is null:
        final String prompt;
        if (theSummaryLength != null) {
            prompt = "You MUST respond in exactly " + theSummaryLength + " words or less."
                    + "Do not exceed this limit under any circumstances. Summarize the "
                    + "following text:\n\n"
                    + theCombinedText;
        } else {
            prompt = "Summarize the following text:\n\n"
                    + theCombinedText;
        }

        ollamaRequest.setPrompt(prompt);
        ollamaRequest.setModel("llama3.1");
        ollamaRequest.setStream(false);
        return ollamaRequest;
    }

    public int getSummaryLength() {
        
    }
}
