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
    private String myText;
    private Integer myMaxLength;

    public String getText() {
        return myText;
    }

    public Integer getMaxLength() {
        return myMaxLength;
    }

    public String setText(String theText) {
        return myText = theText;
    }

    public Integer setMaxLength(Integer theLength) {
        return myMaxLength = theLength;
    }
}
