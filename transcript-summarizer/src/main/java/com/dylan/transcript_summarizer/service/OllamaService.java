package com.dylan.transcript_summarizer.service;

import com.dylan.transcript_summarizer.dto.OllamaRequest;
import com.dylan.transcript_summarizer.dto.OllamaResponse;
import com.dylan.transcript_summarizer.dto.SummarizeRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OllamaService {

    private final RestTemplate myRestTemplate;

    public OllamaService(final RestTemplate theRestTemplate) {
        super();
        myRestTemplate = theRestTemplate;
    }

    public String summarize(SummarizeRequest theRequest) {
        OllamaRequest ollamaRequest = new OllamaRequest();

        //curl.exe -X POST http://localhost:8080/api/summarize
        // -H "Content-Type: application/json"
        // -d "{\"text\":\"This is text to be sent to Ollama\",\"maxLength\":50}"

        //Check if the length field is null:
        final String prompt;
        if (theRequest.getMaxLength() != null) {
            prompt = "In " + theRequest.getMaxLength() + " words or less,"
                    + " summarize the following text:\n\n"
                    + theRequest.getText();
        } else {
            prompt = "Summarize the following text:\n\n"
                    + theRequest.getText();
        }

        ollamaRequest.setPrompt(prompt);
        ollamaRequest.setModel("llama3.1");
        ollamaRequest.setStream(false);

        OllamaResponse response = myRestTemplate.postForObject(
                "http://localhost:11434/api/generate", //Ollama's URL
                ollamaRequest, //OllamaRequest object
                OllamaResponse.class //Convert JSON to this class
        );
        if (response == null) {
            throw new IllegalStateException("No response from Ollama.");
        }
        return response.getResponse();
    }
}
