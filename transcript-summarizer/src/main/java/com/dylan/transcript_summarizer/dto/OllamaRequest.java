package com.dylan.transcript_summarizer.dto;

public class OllamaRequest {
    private String model = "llama3.1";
    private String prompt;
    private Boolean stream = false;

    public OllamaRequest() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(final String theNewModel) {
        model = theNewModel;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(final String theNewPrompt) {
        prompt = theNewPrompt;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean theStream) {
        stream = theStream;
    }
}
