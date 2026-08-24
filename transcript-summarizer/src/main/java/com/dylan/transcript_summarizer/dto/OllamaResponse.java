package com.dylan.transcript_summarizer.dto;

public class OllamaResponse {
    private String model = "llama3.1";
    private String response;
    private Boolean done;

    public OllamaResponse() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(final String theNewModel) {
        model = theNewModel;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(final String theNewResponse) {
        response = theNewResponse;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(final Boolean theNewStatus) {
        done = theNewStatus;
    }
}
