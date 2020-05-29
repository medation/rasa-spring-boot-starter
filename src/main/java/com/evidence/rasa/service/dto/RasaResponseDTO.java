package com.evidence.rasa.service.dto;

import java.io.Serializable;

public class RasaResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String recipient_id;

    private String text;

    public String getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(String recipient_id) {
        this.recipient_id = recipient_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "RasaResponseDTO{" +
                "recipient_id='" + recipient_id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
