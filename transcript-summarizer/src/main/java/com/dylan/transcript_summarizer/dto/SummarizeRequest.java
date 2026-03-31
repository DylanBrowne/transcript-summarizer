package com.dylan.transcript_summarizer.dto;

/**
 * Data Transfer Object (DTO) used to transfer data between
 * the client (Firefox) and server (Backend - controllers,
 * services, logic) layers of the application.
 *<p>
 * This class encapsulates request or response data and helps
 * isolate the internal domain model from external API contracts.
 *<p>
 * DTOs improve security, maintainability, and clarity by exposing
 * only the data necessary for communication.
 */
public class SummarizeRequest {
    private String text;
    private Integer maxWords;
    private String instruction;
    private String url;

    public String getText() {
        return text;
    }

    public Integer getMaxWords() {
        return maxWords;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getUrl() {
        return url;
    }

    public void setText(String theText) {
        text = theText;
    }

    public void setMaxWords(Integer theLength) {
        maxWords = theLength;
    }

    public void setInstruction(final String theInstruction) {
        instruction = theInstruction;
    }

    public void setUrl(final String theURL) {
        url = theURL;
    }
}
